package ioliu;

import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		FileWriter fw=null;
		try {
		 fw=new FileWriter("E:/test2.txt");
			for(int i=0;i<1000;i++) {
				fw.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("file writed");
	}

}
