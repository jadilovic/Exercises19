package Exercises;

	import java.net.*;
	import java.io.*;
	import java.util.*;

	public class Client {

		public static void main(String args[]) {
			String st = "Hai";
			int n1 = 10221;
			Vector v = new Vector();
			v.addElement(st);
			v.addElement(n1);
			String hostname = "localhost"; //slogix.in:

			/* To execute in two different systems hostname of the system in which server program resides should be provided in hostname variable.
				example:soft37
				How to find hostname?
				Go to command prompt and type: hostname
			 	*/

			try {
				Socket s = new Socket(hostname, 2222);
				OutputStream os = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(v);
				System.out.println("Sending the data " + st + ": "+n1);
				oos.flush();
				oos.close();
				s.close();
			}
			catch(Exception e) {
				System.out.println(e);
				}
			}
}
