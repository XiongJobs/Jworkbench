package ioliu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOtransform {

	public static void main(String[] args) {
		try {
			OutputStreamWriter osw=new OutputStreamWriter(
					new FileOutputStream("E:/test.txt",true));
			osw.write("write by programe");
			
	        osw.write(System.getProperty("line.separator"));
	        
	        System.out.println(osw.getEncoding());
	        
	        osw.flush();
	        osw.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
