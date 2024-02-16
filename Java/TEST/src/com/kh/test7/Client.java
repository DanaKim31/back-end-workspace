package com.kh.test7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			// 2. ip, 포트번호 지정되어 있지 않았다. 
			String ip = InetAddress.getLocalHost().getHostAddress();
			try {
				Socket s = new Socket(ip, 3000);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
