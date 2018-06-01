 package ioliu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) {
		FileInputStream fin=null;
		BufferedInputStream buin=null;
		int temp=0;
		
		try {
			fin=new FileInputStream("E:/test.txt");
			buin=new BufferedInputStream(fin);
			
			System.out.println(buin.read());
			
			buin.mark(20);
			
			for(int i=0;i<=10  && ((temp=buin.read())!=-1);i++) {
				System.out.print((char)temp+" ");
			}
			System.out.println();
			buin.reset();
			for(int i=0;i<=10  && ((temp=buin.read())!=-1);i++) {
				System.out.print(temp+" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				buin.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
