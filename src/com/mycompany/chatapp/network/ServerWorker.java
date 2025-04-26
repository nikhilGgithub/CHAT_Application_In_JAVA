package com.mycompany.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

//thread is worker
//worker need a job to performe 
//for job u give runnable
//once job is created via runnable so write the job
//assing the job to the thread
//public class ServerWorker implements Runnable{  //or 

public class ServerWorker extends Thread{
private Socket clienSocket;
private InputStream in;
private OutputStream out;
private Server server;
public ServerWorker(Socket clienSocket,Server server) throws IOException {
	this.server=server;
	this.clienSocket=clienSocket;
	in=clienSocket.getInputStream();//client data read krke aaunga
out =clienSocket.getOutputStream();///client data write bhi krke aunga
System.out.println("New Client comes...");
}
	@Override
	public void run() {
		//read data from the client and broadcast the data to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line ;
		try {
		while(true) {
			
				line =br.readLine();///need  \n
				System.out.println("Line Read ..."+line);
				if(line.equalsIgnoreCase("quit")) {
					break;///client chat end if say quit
				}
				
				///this only for one 
				
//				out.write(line.getBytes());
				
				///i want broadcast to all so then
				for( ServerWorker serverWorker: server.workers) {
					line=line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
			if(br!=null) {
				br.close();
			}
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clienSocket!=null) {
				clienSocket.close();
			}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	


}

