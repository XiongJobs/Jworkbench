package test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fi=new File("E:/�ļ�/Study/Java�̳�/01��һ����J2SE");
		if(fi.exists()) {
			File[] fson=fi.listFiles();
			for(int i=0;i<fson.length;i++) {
				if(fson[i].isFile()) {
					System.out.println(fson[i].getName()+"   ���ļ�");
				}else if(fson[i].isDirectory()) {
					System.out.println(fson[i].getName()+" ���ļ���");
				}else {
					System.out.println("����Ŀ¼Ҳ�����ļ�������֣���");
				}
			}
		}else {
			System.out.println("û�д�·��");
		}
	}

}
