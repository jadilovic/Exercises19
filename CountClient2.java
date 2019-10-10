package Exercises;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CountClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost", 1034);
		
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		String mess = fromServer.readUTF();
		System.out.println(mess);
		socket.close();
	}
}
