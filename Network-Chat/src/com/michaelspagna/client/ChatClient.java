package com.michaelspagna.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author michaelspagna
 *
 */
public class ChatClient {
	
	/**
	 * 
	 */
	PrintWriter writer;
	BufferedReader reader;
	Socket sock;
	ChatGui gui;
	
	/**
	 * 
	 */
	public void run() {
		guiSetUp();
		networkSetUp();
		threadSetUp();
	}
	
	/**
	 * 
	 */
	private void guiSetUp() {
		gui = new ChatGui();
		gui.setBtnListener(this);
		gui.setFieldListener(this);
		gui.run();
	}
	
	/**
	 * 
	 */
	private void networkSetUp() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader stream = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(stream);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("NetWork Established");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Unkown Host");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("I/O Exception");
		}
	}
	
	/**
	 * 
	 */
	private void threadSetUp() {
		Thread readThread = new Thread(new ChatReader(this, gui));
		readThread.start();
	}
	
	/**
	 * 
	 * @param message: 
	 */
	public void writeToWriter(String message) {
		writer.println(message);
		writer.flush();
	}
	
	/**
	 * 
	 * @return
	 */
	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}