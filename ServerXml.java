package socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ServerXml extends JFrame {

	private JPanel contentPane;
	public volatile JTextArea textArea;
	public JTextArea textArea_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	public final JTextField textField = new JTextField();
	public JButton button;

	public ServerXml() {
		setForeground(new Color(0, 0, 0));
		setTitle("\u670D\u52A1\u5668\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(218, 10, 106, 25);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u670D\u52A1\u5668\u7AEF");
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(255, 0, 0));
		panel.add(label);

		JLabel label_1 = new JLabel("\u6D88\u606F\u5217\u8868");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(23, 47, 91, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u62A5\u6587\u4FE1\u606F");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(283, 47, 54, 15);
		contentPane.add(label_2);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 72, 234, 204);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(22, 72, 234, 204);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(293, 72, 234, 204);
		contentPane.add(scrollPane_1);

		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(283, 72, 234, 204);
		scrollPane_1.setViewportView(textArea_1);
		
		button = new JButton("\u53D1\u9001");
		button.setBounds(163, 275, 93, 25);
		contentPane.add(button);
		
		textField.setBounds(23, 275, 139, 25);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
