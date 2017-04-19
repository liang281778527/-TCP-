package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;

public class chatThread extends Thread{
	Socket s=null;
	ClientXml frame;
	public chatThread(Socket s,ClientXml frame){
		this.s=s;
		this.frame=frame;
	}
	
	@Override
	public void run() {
	}
	
/*	public void wenjian(Socket s, String path) throws Exception {
		int count = 0;
		File file = null;
		FileInputStream fis = null;
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		file = new File(path);
		dos.writeUTF("fileTrans");
		dos.flush();
//		String rcvstr=dis.readUTF();
//		frame.fun(rcvstr);
//		if (rcvstr.equals("acceptTrans")) {
			dataFrame data=new dataFrame();
			fis = new FileInputStream(file);
			dos.writeUTF(file.getName());
			while ((data.length = fis.read(data.bytes, 0, data.bytes.length)) > 0) {
				count++;
				data.num=count;
				frame.fun("正在发送第" + data.num + "个帧");
				data.cal(data);
				dos.write(data.bytes, 0, data.length);
				dos.flush();
				int status = dis.read();
				while (true) {
					if (status == 0) {
						frame.fun("服务器已成功接收第" + count + "帧");
						break;
					}
					if (status == 1) {
						frame.fun("该帧已丢失，正在重发...");
						dos.write(data.bytes, 0,data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
					if (status == 2) {
						frame.fun("该帧已出错，正在重发...");
						dos.write(data.bytes, 0, data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
					if (status == -1) {
						frame.fun("未接受到确认！正在重发...");
						dos.write(data.bytes, 0, data.length);
						dos.flush();
						status = dis.read();
						continue;
					}
				}
			}
//		} else
//			frame.fun("服务器拒绝接受文件！");
		dos.close();
		fis.close();
		dis.close();
	}
	
	public void getNews(){
		try {
			DataInputStream dis =new DataInputStream(s.getInputStream());
			String rcvstr;
			frame.button_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						frame.fun("正在发送文件");
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
							frame.fun("文件路径错误或服务器拒绝接受文件");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			});
			rcvstr=dis.readUTF();
			date d=new date();
			frame.fun(d.time+"  服务器\r\n"+rcvstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
