package Exercises;

	import java.net.*;
	import java.io.*;
	import java.util.*;
	
	public class Server {
		public static void main(String args[]) {
			Vector vec = new Vector();
			
			try {
				ServerSocket ss = new ServerSocket(2222);
				System.out.println("Server is waiting");
				Socket sa = ss.accept();

				System.out.println("Connected with client");

				InputStream is = sa.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				vec = (Vector)ois.readObject();

				String s1 = (String)vec.elementAt(0);
				Integer s2 = (Integer)vec.elementAt(1);
				System.out.println("Reading data "+ s1 + ": "+s2);
				ois.close();
				sa.close();
				ss.close();
			}
			catch(Exception e) {
				System.out.println(e);
				}
			}
		}