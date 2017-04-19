package socket;

import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		ServerXml frame = new ServerXml();
		frame.setVisible(true);
		frame.textArea.append("���ڵȴ�����...\r\n");
		while (true) {
			Socket cs = ss.accept();
			ServerThread serverThread = new ServerThread(cs, frame);
			frame.textArea.append("�û�������\r\n");
			serverThread.start();
		}

	}
}