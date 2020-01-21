package com.michaelspagna.client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatGui {
	JFrame frame;
	JPanel chatPanel;
	JPanel sendPanel;
	JScrollPane scroll;
	JTextArea chatArea;
	JTextField sendField;
	JButton sendBtn;
	
	public ChatGui() {
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame("Network Chat Room");
		chatPanel = new JPanel();
		sendPanel = new JPanel();
		chatArea = new JTextArea(15,38);
		scroll = new JScrollPane(chatArea);
		sendField = new JTextField(30);
		sendBtn = new JButton("send");
		
	}
	
	
	public void run() {
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatPanel.add(scroll);
		sendPanel.add(sendField);
		sendPanel.add(sendBtn);
		frame.getContentPane().add(BorderLayout.CENTER, chatPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, sendPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public String getMessage() {
		String message = sendField.getText();
		sendField.setText("");
		sendField.requestFocusInWindow();
		return message;
	}
	
	public void setBtnListener(ChatClient cc) {
		sendBtn.addActionListener(new BtnListener(cc, this));
	}
	
	public void setFieldListener(ChatClient cc) {
		sendField.addKeyListener(new FieldListener(cc, this));
	}
	
	public void appendArea(String message) {
		System.out.println("Client read: " + message);
		chatArea.append(message + '\n');
	}
	
	
}