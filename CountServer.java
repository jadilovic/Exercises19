package Exercises;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CountServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socketS = new ServerSocket(1034);
		
		Socket socket = socketS.accept();
		System.out.println("Server is waiting for clients requests");
		int count = 0;
		
		while(socket != null){
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
			InetAddress inet = socket.getInetAddress();
			String hName = inet.getHostName();
			String ipAddress = inet.getHostAddress();
			count++;
			String mess = "Your host name is " + hName + ", your IP address is " + ipAddress + ", and your "
					+ "client number is " + count;
			toClient.writeUTF(mess);
			//socket = socketS.accept();
		}
		socketS.close();
	}
}
