package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		// Establishing connection with the server
		Socket socket = new Socket("localhost", 1031);
		
		// Created data input and output stream
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		
		// Getting inet infor from server
		String infoFromServer = fromServer.readUTF();
		System.out.println(infoFromServer);
		
		// Sending info back to server
		String returnInfo = "Thank you for inet info";
		toServer.writeUTF(returnInfo);
		toServer.flush();
		socket.close();
	}
}
