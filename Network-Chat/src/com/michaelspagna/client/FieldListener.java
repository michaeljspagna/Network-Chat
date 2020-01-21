package com.michaelspagna.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Key Listener for the Gui TextField
 * @author michaelspagna
 *
 */
public class FieldListener implements KeyListener{
	
	/**
	 * 
	 */
	ChatClient client;
	ChatGui gui;
	
	/**
	 * Constructor for Field Listener
	 * @param chatClient: Current instance of ChatClient
	 * @param chatGui: Current instance of ChatGui
	 */
	public FieldListener(ChatClient chatClient, ChatGui chatGui) {
		client = chatClient;
		gui = chatGui;
	}
	/**
	 * Sends the message from the textfield to the server
	 * when the enter key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String message = gui.getMessage();
			client.writeToWriter(message);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
}
