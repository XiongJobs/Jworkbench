package network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerLong {

	public static void main(String[] args) {
		byte[] buf=new byte[1024];
		DatagramPacket dap=new DatagramPacket(buf,buf.length);
		DatagramSocket sok=null;
		
		try {
			sok =new DatagramSocket(6888);
			
			if(sok !=null) {
				System.out.println("UDP server start");
				while(true) {
					sok.receive(dap);
					ByteArrayInputStream bais =new ByteArrayInputStream(buf);
					DataInputStream dis=new DataInputStream(bais);
					System.out.println(dis.readLong());
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
