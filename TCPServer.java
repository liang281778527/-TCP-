package socket;

import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		ServerXml frame = new ServerXml();
		frame.setVisible(true);
		frame.textArea.append("正在等待链接...\r\n");
		while (true) {
			Socket cs = ss.accept();
			ServerThread serverThread = new ServerThread(cs, frame);
			frame.textArea.append("用户已连接\r\n");
			serverThread.start();
		}

	}
}