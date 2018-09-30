package demo;

public class Calculation {

	public Calculation() {
		// TODO Auto-generated constructor stub
	}
	
	public int add (int a,int b) {
		return a+b;
	}
	
	public int subtract(int a,int b) {
		return a-b;
	}
	
	public int mult(int a,int b) {
		return a*b;
	}
	
	public int divid(int a,int b) {
		if(b !=0) {
			return a/b;
		}else {
			return 0;
		}
	}
}
