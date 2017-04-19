package socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ClientXml {

	private JFrame frame;
	public volatile JTextArea textArea;
	public JButton button;
	public JButton button_1;
	public JTextField textField;

	public ClientXml() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5BA2\u6237\u7AEF");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("ËÎÌו", Font.PLAIN, 12));
		frame.setBounds(100, 100, 578, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 562, 355);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5BA2\u6237\u7AEF");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setBounds(186, 20, 126, 36);
		panel.add(label);

		button = new JButton("\u53D1\u9001\u6D88\u606F");
		button.setBackground(Color.CYAN);
		button.setBounds(315, 227, 93, 37);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 62, 360, 167);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(49, 62, 359, 167);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(48, 227, 268, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		button_1 = new JButton("\u53D1\u9001\u6587\u4EF6");
		button_1.setBounds(446, 221, 81, 48);
		panel.add(button_1);

		frame.setVisible(true);
	}

	public void fun(String str) {
		textArea.append(str + "\r\n");
	}
}
