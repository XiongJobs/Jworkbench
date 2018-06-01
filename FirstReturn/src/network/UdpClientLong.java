package network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpClientLong {

	public static void main(String[] args) {
		long n= 485734L;
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		try {
			dos.writeLong(n);
			byte[]buf=baos.toByteArray();
			DatagramPacket dp=new DatagramPacket(buf,buf.length,
					new InetSocketAddress("127.0.0.1",6888));
			DatagramSocket ds=new DatagramSocket(6889);
			ds.send(dp);
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
