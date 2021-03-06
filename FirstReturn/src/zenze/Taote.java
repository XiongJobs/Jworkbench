package zenze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Taote {

	public static void main(String[] args) {
/*		System.out.println("zenzebiao".matches("..."));
		System.out.println("z11213o".replaceAll("\\d", "-")); //数字替换成“-”
		
		Pattern p=Pattern.compile("[a-z]{3}");  //匹配3位a-z的以为字母
		Matcher m=p.matcher("fwo");  //匹配结果保留到matcher对象中
		System.out.println(m.matches()); //打印匹配结果        */
		
/*		//不经过预编译直接用matches,建议使用Pattern预编译提高效率
		System.out.println("fos".matches("[a-z]{3}")); */
		
/*		Pattern p=Pattern.compile("java");  //匹配3位a-z的以为字母
		Matcher m=p.matcher("javajava");  //匹配结果保留到matcher对象中
		System.out.println(m.matches()); //打印匹配结果
*/		
		/* .  * + 符号认识    */
		 // .代表一个字符  *代表零个或多个字符  ？代表零个或一个字符  +代表一个或多个字符 
/*		print(("fadf".matches("f*a*d*f*")));
		print("234354552455656456".matches("\\d{3,18}"));
		print("192".matches("[0-2][0-9][0-9]"));*/
		
		//范围
/*		print("a".matches("[abc]"));
		print("a".matches("[^abc]"));
		print("A".matches("[a-zA-Z]"));
		print("A".matches("[a-z]|[A-Z]"));
		print("B".matches("[a-z[A-Z]]"));
		print("B".matches("[A-Z && [RFG]]"));*/
		
		//认识  \s \w \d \
/*		print(" \n\r\t".matches("\\s{4}"));
		print(" ".matches("\\S"));
		print("a_8".matches("\\w{3}"));
		print("abc86&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		print("\\".matches("\\\\"));*/
		
		//边界处理
		print("hello sir".matches("^h.*"));
		print("hello sir".matches(".*is$"));
		print("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		
/*		for(int i=0;i<10;i++) {
			System.out.println(Math.random());
		}*/
		
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}

}
