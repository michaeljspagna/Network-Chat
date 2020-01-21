package com.michaelspagna.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldListener implements KeyListener{
	ChatClient client;
	ChatGui gui;
	
	
	public FieldListener(ChatClient chatClient, ChatGui chatGui) {
		client = chatClient;
		gui = chatGui;
	}

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
