package Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class RadiusServer {

	public static void main(String[] args) throws Exception {
		
		// Creating Server socket
		ServerSocket sSocket = new ServerSocket(1030);
		System.out.println("Server socket is activated at " + new Date() + " and waiting...");
		System.out.println("Server is waiting for client request and input on radius...");
		
		// Upcoming traffic is awaited
		Socket socket = sSocket.accept();
		
		// Creating input and output data streams
		DataInputStream fromClient = new DataInputStream(socket.getInputStream());
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		
		// Receiving data from client
		double receivedRadius = fromClient.readDouble();
		System.out.println("Received radius from client: " + receivedRadius);
		
		// Calculating area of circle
		double circleArea = receivedRadius * receivedRadius * Math.PI;
		System.out.println("Area of circle to be sent to client" + circleArea);
		circleArea = Math.round(circleArea);
		
		// Sending circle area to the client
		toClient.writeDouble(circleArea);
		sSocket.close();
	}

}
