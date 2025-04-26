package com.mycompany.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.mycompany.chatapp.utils.ConfigReader;

public class Server {
ServerSocket serverSocket;
ArrayList<ServerWorker>workers=new ArrayList<ServerWorker>();//contains all the client socket


/* Only for single client
 * 
 * 
	public Server() throws IOException {
		int PORT=Integer.parseInt (ConfigReader.getValue("PORTNO"));	
		serverSocket=new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the clint Connection.. ");
Socket socket=serverSocket.accept();///Handshaking 
System.out.println("Clint joins the Server");
 InputStream in= socket.getInputStream();//read byte from network
byte arr[]=  in.readAllBytes();
 
String str=new String (arr);
System.out.println("Message Rec from the client "+str);

in.close();
 socket.close();
	}
	*
	*
	*/


///OR For multiple client
public Server() throws IOException {
	int PORT=Integer.parseInt (ConfigReader.getValue("PORTNO"));	
	serverSocket=new ServerSocket(PORT);
	System.out.println("Server Start ans waiting for the client to join..");
	handleClientRequest();
	
}
	///multiple client handshaking
	public void  handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocket.accept();//handshaking
			//per client per thread
			ServerWorker serverWorker=new ServerWorker(clientSocket,this);///creating a new worker /thread
		workers.add(serverWorker);
	
			serverWorker.start();
		}
	}
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Server server=new Server();
	}

}
