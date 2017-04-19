package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeoutException;

import javax.swing.JFileChooser;

public class TCPClient{
	int sendWin = 5;
	static ClientXml frame = null;

	public static void main(String argv[]) throws Exception {
		try {
				Socket s = new Socket("localhost", 8888);
				frame = new ClientXml();
			//	chatThread chatthread=new chatThread(s,frame);
			//	chatthread.start();
				frame.button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
								String str;
								DataOutputStream dos=new DataOutputStream(s.getOutputStream());
								str=frame.textField.getText();
								frame.textField.setText("");
								date d=new date();
								frame.textArea.append(d.time+"  �ͻ���\r\n"+str+"\r\n");
								dos.writeUTF(str);
								dos.flush();
						} 
						catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				});
				
				frame.button_1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							frame.fun("���ڷ����ļ�");
							JFileChooser jf = new JFileChooser();
							jf.setMultiSelectionEnabled(true);
							jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
							int returnval = jf.showOpenDialog(jf);
							String filePath = null;
							if (returnval == JFileChooser.APPROVE_OPTION) {
								filePath = jf.getSelectedFile().getPath();
							}
							if (filePath != null)
							{
								wenjian(s, filePath);
							}
							else
								frame.fun("�ļ�·�������������ܾ������ļ�");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				});
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void wenjian(Socket s, String path) throws IOException {
		int count = 0;
		File file = null;
		FileInputStream fis = null;
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		file = new File(path);
		dos.writeUTF("fileTrans");
		dos.flush();
		String rcvstr=dis.readUTF();
		frame.fun(rcvstr);
		if (rcvstr.equals("accept fileTrans")) {
			dataFrame data=new dataFrame();
			fis = new FileInputStream(file);
			dos.writeUTF(file.getName());
			dos.flush();
			while ((data.length = fis.read(data.bytes, 0, data.bytes.length)) > 0) {
				count++;
				data.num=count;
				frame.fun("���ڷ��͵�" + data.num + "��֡");
				data.cal(data);
				dos.write(data.bytes, 0, data.length);
				dos.flush();
				int status;
				status = dis.read();
				while (true) {
					if (status == 0) {
						frame.fun("�������ѳɹ����յ�" + count + "֡");
						break;
					}
					if (status == 1) {
						frame.fun("��֡�Ѷ�ʧ�������ط�...");
						dos.write(data.bytes, 0,data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
					if (status == 2) {
						frame.fun("��֡�ѳ��������ط�...");
						dos.write(data.bytes, 0, data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
					if (status == -1) {
						frame.fun("δ���ܵ�ȷ�ϣ������ط�...");
						dos.write(data.bytes, 0, data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
				}
			}
		} else
			frame.fun("�������ܾ������ļ���");
		dos.close();
		dis.close();
	}
	
	public static void getNews(Socket s,ClientXml frame){
		try {
			DataInputStream dis =new DataInputStream(s.getInputStream());
			String rcvstr;
			rcvstr=dis.readUTF();
			date d=new date();
			frame.fun(d.time+"  ������\r\n"+rcvstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
