package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class InetAddressServer {

	public static void main(String[] args) throws IOException {
		
		// Server socket created
		ServerSocket serverSocket = new ServerSocket(1031);
		System.out.println("Server has been activated on " + new Date());
		
		// Socket is waiting for the client request
		Socket socket = serverSocket.accept();
		System.out.println("Server is waiting for the client to connect");

		// Inet Address class created in order to get info about connected client
		InetAddress inetAddClient = socket.getInetAddress();
		String hostName = inetAddClient.getHostName();
		String hostAddress = inetAddClient.getHostAddress();
		
		// Created data output and input streams
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		DataInputStream fromClient = new DataInputStream(socket.getInputStream());
		
		// Sending Inet info to the connected client
		String inetInfo = "You have host name " + hostName + " and address " + hostAddress;
		toClient.writeUTF(inetInfo);
		
		// Getting response from the client
		String clientResponse = fromClient.readUTF();
		System.out.println("Client responded with: " + clientResponse);

		serverSocket.close();
	}

}
