package com.michaelspagna.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author michaelspagna
 *
 */
public class BtnListener implements ActionListener{
	
	/**
	 * 
	 */
	ChatClient client;
	ChatGui gui;
	
	/**
	 * 
	 * @param chatClient
	 * @param chatGui
	 */
	public BtnListener(ChatClient chatClient, ChatGui chatGui) {
		client = chatClient;
		gui = chatGui;
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		String message = gui.getMessage();
		client.writeToWriter(message);
	}

}
