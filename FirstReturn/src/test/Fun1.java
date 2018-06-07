package test;

public class Fun1 {

	public static void main(String[] args) {
		int i=11;
		System.out.println(i);
		changeint(i);
		System.out.println(i);
	}
	
	public static void changeint(int i) {
		i=12;
	}
}
