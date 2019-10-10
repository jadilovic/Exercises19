package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RadiusClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Asking user to provide radius to be sent to server
		System.out.println("Please enter radius of the circle");
		Scanner input = new Scanner(System.in);
		String radius = input.nextLine();
		input.close();
		
		// Creating socket for communication with the server
		Socket socket = new Socket("localhost", 1030);
		
		// Creating data input and output streams
		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		
		// Sending radius to server
		toServer.writeUTF(radius);
		System.out.println("Radius sent to the server: " + radius);
		
		// Receiving circle area from the server
		String circleArea = fromServer.readUTF();
		System.out.println("The area of the circle calculated by the server is: " + circleArea);
		socket.close();
	}

}
