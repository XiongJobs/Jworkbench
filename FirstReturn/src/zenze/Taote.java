package zenze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Taote {

	public static void main(String[] args) {
/*		System.out.println("zenzebiao".matches("..."));
		System.out.println("z11213o".replaceAll("\\d", "-")); //�����滻�ɡ�-��
		
		Pattern p=Pattern.compile("[a-z]{3}");  //ƥ��3λa-z����Ϊ��ĸ
		Matcher m=p.matcher("fwo");  //ƥ����������matcher������
		System.out.println(m.matches()); //��ӡƥ����        */
		
/*		//������Ԥ����ֱ����matches,����ʹ��PatternԤ�������Ч��
		System.out.println("fos".matches("[a-z]{3}")); */
		
/*		Pattern p=Pattern.compile("java");  //ƥ��3λa-z����Ϊ��ĸ
		Matcher m=p.matcher("javajava");  //ƥ����������matcher������
		System.out.println(m.matches()); //��ӡƥ����
*/		
		/* .  * + ������ʶ    */
		 // .����һ���ַ�  *������������ַ�  �����������һ���ַ�  +����һ�������ַ� 
/*		print(("fadf".matches("f*a*d*f*")));
		print("234354552455656456".matches("\\d{3,18}"));
		print("192".matches("[0-2][0-9][0-9]"));*/
		
		//��Χ
/*		print("a".matches("[abc]"));
		print("a".matches("[^abc]"));
		print("A".matches("[a-zA-Z]"));
		print("A".matches("[a-z]|[A-Z]"));
		print("B".matches("[a-z[A-Z]]"));
		print("B".matches("[A-Z && [RFG]]"));*/
		
		//��ʶ  \s \w \d \
/*		print(" \n\r\t".matches("\\s{4}"));
		print(" ".matches("\\S"));
		print("a_8".matches("\\w{3}"));
		print("abc86&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		print("\\".matches("\\\\"));*/
		
		//�߽紦��
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