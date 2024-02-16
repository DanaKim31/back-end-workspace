package com.kh.test7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			ServerSocket server = new ServerSocket();
			Socket s = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
