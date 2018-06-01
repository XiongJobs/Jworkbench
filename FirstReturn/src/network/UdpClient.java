package network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {

	public static void main(String[] args) {
		byte[] buf=("Hello".getBytes());
			
		DatagramPacket dp=new DatagramPacket(buf,buf.length,
				new InetSocketAddress("127.0.0.1",7888));
		DatagramSocket ds=null;
		
		try {
			ds=new DatagramSocket(7889);
			if(ds !=null) {
				ds.send(dp);
				ds.close();
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
