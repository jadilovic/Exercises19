package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class JavaServer {

	public static void main(String[] args) throws Exception {
		
		// Server socket created
		ServerSocket server = new ServerSocket(1026);
		System.out.println("Server socket is activated " + new Date() + " and is waiting");
		
		// Upcoming traffic is awaited
		Socket socket = server.accept();
		
		// Create data input and output streams
		DataInputStream inputClient = new DataInputStream(socket.getInputStream());
		DataOutputStream outputClient = new DataOutputStream(socket.getOutputStream());
		
		// Receive sentence from the client
		String sentence = inputClient.readUTF();
		
		System.out.println("Received sentence from the client is " + sentence);
		
		// Write and send back sentence to the client
		outputClient.writeUTF(sentence.toUpperCase());
		
		System.out.println("Sentence '" + sentence + "' was sent back to client");
		server.close();
	}

}
