package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		ServerSocket serv =null;
		Socket sok=null;
		int num=0;
	    
		try {
			serv=new ServerSocket(6667);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {			    
			   if(serv !=null) {
				   System.out.println("server start");
			    
				   while(true) {
			    	sok=serv.accept();
					if(sok !=null) {
						num++;
						System.out.println("client "+num+" connect");
						
						DataInputStream dis=new DataInputStream(sok.getInputStream());
						System.out.println(dis.readUTF());
						
						OutputStream os=sok.getOutputStream();
						DataOutputStream dos=new DataOutputStream(os);
						dos.writeUTF("hello client"+sok.getInetAddress()+": "
								+sok.getPort());
						
						dis.close();
						dos.close();
						os.close();
						sok.close();
						
					}
			    }			    
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}
