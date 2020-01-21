package com.michaelspagna.server;

/**
 * Run this file to activate the chat server
 * The server is capable of supporting multiple chat clients
 * @author michaelspagna
 *
 */
public class RunServer {

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.run();
	}
}
