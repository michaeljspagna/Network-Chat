package com.michaelspagna.client;

public class ChatReader implements Runnable{
	
	ChatClient client;
	ChatGui gui;
	
	public ChatReader(ChatClient chatClient, ChatGui chatGui) {
		client = chatClient;
		gui = chatGui;
	}

	
	@Override
	public void run() {
		String message;
		try {
			
			while((message = client.readLine()) != null) {
				gui.appendArea(message);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
