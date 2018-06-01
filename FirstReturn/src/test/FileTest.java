package test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fi=new File("E:/文件/Study/Java教程/01第一部分J2SE");
		if(fi.exists()) {
			File[] fson=fi.listFiles();
			for(int i=0;i<fson.length;i++) {
				if(fson[i].isFile()) {
					System.out.println(fson[i].getName()+"   是文件");
				}else if(fson[i].isDirectory()) {
					System.out.println(fson[i].getName()+" 是文件夹");
				}else {
					System.out.println("不是目录也不是文件，好奇怪？？");
				}
			}
		}else {
			System.out.println("没有此路径");
		}
	}

}
