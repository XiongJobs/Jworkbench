package ioliu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buffereader {

	public static void main(String[] args) {
		try {
			FileInputStream inp= new FileInputStream("E:/test.txt");
			InputStreamReader isr=new InputStreamReader(inp);
			BufferedReader br=new BufferedReader(isr);
			String b="";
			while((b=br.readLine())!=null) {
				System.out.println(b);
			}
			br.close();
			isr.close();
			inp.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
