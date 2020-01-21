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
	/**
	 * 
	 */
	JFrame frame;
	JPanel chatPanel;
	JPanel sendPanel;
	JScrollPane scroll;
	JTextArea chatArea;
	JTextField sendField;
	JButton sendBtn;
	
	/**
	 * ChatGui constructor
	 */
	public ChatGui() {
		initialize();
		
	}
	/**
	 * Initializes the components of the Gui
	 */
	private void initialize() {
		frame = new JFrame("Network Chat Room");
		chatPanel = new JPanel();
		sendPanel = new JPanel();
		chatArea = new JTextArea(15,38);
		scroll = new JScrollPane(chatArea);
		sendField = new JTextField(30);
		sendBtn = new JButton("send");
		
	}
	
	/**
	 * Builds and runs the gui
	 */
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
	
	/**
	 * Get user input from the textfield
	 * @return User message from the textfield
	 */
	public String getMessage() {
		String message = sendField.getText();
		sendField.setText("");
		sendField.requestFocusInWindow();
		return message;
	}
	
	/**
	 * Adds a BtnListener to the sendBtn
	 * @param client: Current instance of ChatClient 
	 */
	public void setBtnListener(ChatClient client) {
		sendBtn.addActionListener(new BtnListener(client, this));
	}
	
	/**
	 * Adds a FieldListener to the sendField
	 * @param client: Current insance of ChatClient
	 */
	public void setFieldListener(ChatClient client) {
		sendField.addKeyListener(new FieldListener(client, this));
	}
	
	/**
	 * Updates the TextArea text
	 * @param message: Text to append to the chatArea
	 */
	public void appendArea(String message) {
		System.out.println("Client read: " + message);
		chatArea.append(message + '\n');
	}
	
	
}