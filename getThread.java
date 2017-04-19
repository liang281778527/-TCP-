package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class getThread extends Thread{
	Socket s=null;
	ServerXml frame=null;
	
	public getThread(Socket s,ServerXml frame){
		this.s=s;
		this.frame=frame;
	}
	@Override
	public void run() {
	}
}
