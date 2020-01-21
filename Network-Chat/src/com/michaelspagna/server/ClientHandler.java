package com.michaelspagna.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable{

	BufferedReader reader;
	Socket sock;
	ChatServer server;
	
	public ClientHandler(ChatServer chatServer, Socket clientSocket) {
		server = chatServer;
		try {
			sock = clientSocket;
			InputStreamReader ipsReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(ipsReader);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String message;
		try {
			while((message = reader.readLine()) != null) {
				System.out.println("Server read: " + message);
				server.tellEveryone(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
