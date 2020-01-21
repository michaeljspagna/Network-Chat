package com.michaelspagna.client;

/**
 * ChatReader gets each message sent to the server as they come in,
 * and appends the new message to the end of the TextArea
 * @author michaelspagna
 *
 */
public class ChatReader implements Runnable{
	
	/**
	 * 
	 */
	ChatClient client;
	ChatGui gui;
	
	/**I
	 * ChatReader constructor
	 * @param chatClient: Current instance of ChatClient
	 * @param chatGui: Current instance of ChatGui
	 */
	public ChatReader(ChatClient chatClient, ChatGui chatGui) {
		client = chatClient;
		gui = chatGui;
	}

	/**
	 * Runs ChatReader, checks the server for any new messages
	 */
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
