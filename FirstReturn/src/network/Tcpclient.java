package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Tcpclient {

	public static void main(String[] args) {
		Socket s=null;
		OutputStream os=null;
		DataOutputStream ds=null;
		int num=0;
		for(int i=0;i<5;i++) {
			try {
				s=new Socket("127.0.0.1",6667);
				if(s !=null) {
					num++;
					System.out.println("client "+num+" start");
					
					os=s.getOutputStream();
					ds=new DataOutputStream(os);
					ds.writeUTF("hello server I'm client "+num);
					ds.flush();
					
					InputStream is =s.getInputStream();
					DataInputStream dis=new DataInputStream(is);
					System.out.println(dis.readUTF());
				
					os.close();
					ds.close();
					dis.close();
					is.close();
					s.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
