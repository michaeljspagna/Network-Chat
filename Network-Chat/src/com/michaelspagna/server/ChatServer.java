package com.michaelspagna.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author michaelspagna
 *
 */
public class ChatServer {

	/**
	 * 
	 */
	ArrayList<Object> outputStream;
	
	/**
	 * 
	 */
	@SuppressWarnings("resource")
	public void run() {
		outputStream = new ArrayList<Object>();
		try {
			ServerSocket sSock = new ServerSocket(5000);
			while(true) {
				Socket sock = sSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				outputStream.add(writer);
				Thread t = new Thread(new ClientHandler(this, sock));
				t.start();
				System.out.println("Connected");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param message:
	 */
	public void tellEveryone(String message) {
		Iterator<Object> it = outputStream.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
