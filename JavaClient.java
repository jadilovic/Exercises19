package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class JavaClient {

	public static void main(String[] args) throws Exception{
		
		// Creating of the socket to connect to the server
		Socket socket = new Socket("localhost", 1029);
		
		// Creating input and output stream for the client
		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		
		// Enter the sentence to be transmitted
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the sentence to be transmited");
		String sentence = input.nextLine();
		input.close();
		
		// Send sentence to the server
		toServer.writeUTF(sentence);
		toServer.flush();
		
		// Receive sentence from the server
		String sentenceS = fromServer.readUTF();
		
		System.out.println("Original sentence from the client " + sentence);
		System.out.println("Received sentence from the server is: " + sentenceS );
		
		socket.close();
	}
}
