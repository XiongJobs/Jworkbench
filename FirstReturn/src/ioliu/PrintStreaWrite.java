package ioliu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreaWrite {

	public static void main(String[] args) {
		PrintStream ps=null;
		try {
			FileOutputStream fos=new FileOutputStream("E:/test.txt");
			ps=new PrintStream(fos);
			if(ps!=null) {
				System.setOut(ps);
			} 
			int ln=0;
			for (char c=0;c<=10000;c++) {
				System.out.print(c+" ");
				if(ln++ >=100) {System.out.println();ln=0;}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
