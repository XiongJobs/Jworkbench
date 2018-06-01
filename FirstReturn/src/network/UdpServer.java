package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

	public static void main(String[] args) {
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		DatagramSocket ds=null;
		
		try {
			ds=new DatagramSocket(7888); //¶Ë¿ÚÎª7888
			
			if(ds !=null) {
				while(true) {
					ds.receive(dp);
					System.out.println(new String(buf,0,dp.getLength()));
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
