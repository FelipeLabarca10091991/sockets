package com.fl.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		
	
	
	ServerSocket servidor = null;
	Socket sc = null;

	DataInputStream in;
	DataOutputStream out;

	final int PUERTO = 5000;

	try {
		servidor = new ServerSocket(PUERTO);
		System.out.println("Cliente Conectado");
		
		while(true) {
			
			sc = servidor.accept();
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			out.writeUTF("Mensaje desde el servidor");
			
			sc.close();
			System.out.println("Cliente desconectado ");
		}
		
	}catch(Exception e) {
		Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
	}
}
}


	
	


