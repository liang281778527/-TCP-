package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ServerThread extends Thread {
	
	Socket s = null;
	ServerXml frame = null;

	public ServerThread(Socket socket, ServerXml frame) {
		this.s = socket;
		this.frame = frame;
	}

	public void sendNews() {
		String str;
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(s.getOutputStream());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		str = frame.textField.getText();
		frame.textField.setText("");
		date d=new date();
		frame.textArea.append(d.time+"  ������\r\n"+str+"\r\n");
		try {
			dos.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		//getThread gt = new getThread(s, frame);
		//gt.start();
		getNews();
		frame.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendNews();
			}
		});

	}
	public void getNews(){
		try {
			String rcvstr,time;
			DataInputStream dis =new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			rcvstr=dis.readUTF();
			if(rcvstr.equals("fileTrans")) {
				int option = JOptionPane.showConfirmDialog(frame, "�ͻ����������ļ��Ƿ���ܣ�", "�ļ�����", JOptionPane.YES_NO_OPTION);
				switch (option) {
					case JOptionPane.YES_OPTION: {
						dos.writeUTF("accept fileTrans");
						dos.flush();
						getfile();
						break;
					}
					case JOptionPane.NO_OPTION: {
						dos.writeUTF("refuse fileTrans");
						break;
					}
				}
				return;
			}
			Date date=new Date();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=df.format(date);
			frame.textArea.append(time+"  �ͻ���\r\n"+rcvstr+"\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getfile(){
		try{
			int count = 0;
			int count1 = 0;
			DataInputStream dis = new DataInputStream(s.getInputStream());;
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			FileOutputStream fos = null;
			byte[] inputByte = null;
			int length = 0;
			//dataFrame data=new dataFrame();
			fos = new FileOutputStream(new File("E:\\" + dis.readUTF()));
			inputByte = new byte[256];
			frame.textArea.append("��ʼ��������...\r\n");
			while (true) {
				if (dis != null) {
					length = dis.read(inputByte, 0, inputByte.length);
				}
				if (length == -1) {
					break;
				}
				count++;
				count1++;
				frame.textArea.append("��" + count + "��֡��" +length + "\r\n");
				int rand = (int) (Math.random() * 3);
				if (rand == 3)
					rand = 2;
				switch (rand) {
				case 0: {
					frame.textArea.append("�ѳɹ�����\r\n");
					dos.write(0);
					fos.write(inputByte, 0, length);
					String str =new String(inputByte);
					str=String.copyValueOf(str.toCharArray(), 0,length);
					frame.textArea_1.append("��"+count+"֡��\r\n"+str+"\r\n");
					dos.flush();
					break;
				} // ��������
	
				case 1: {
					frame.textArea.append("֡��ʧ���ȴ��ͻ����ش�...\r\n");
					dos.write(1);
					count--;
					break;// ֡��ʧ
				}
				case 2: {
					frame.textArea.append("֡�����ȴ��ͻ����ش�...\r\n");
					dos.write(2);
					count--;
					break;// ֡����
				}
				case 3: {
					count--;
					break;// Ӧ��ʧ
				}
				}
	
			}
			frame.textArea.append("��ɽ���,�ش�����:" + (count1 - count) + "\r\n");
			/*
			 * char i =(char)System.in.read(); if(i=='y' || i=='Y') { fis=new
			 * FileInputStream(new File("E:\\1.txt")); byte[] bytes=new byte[1024];
			 * while(fis.read(bytes)>0) { System.out.print(bytes); } }
			 */
			fos.close();
			dis.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
