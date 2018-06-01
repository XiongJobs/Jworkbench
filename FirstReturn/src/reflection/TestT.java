package reflection;

public class TestT {
	int i;
	String s;
	
	static {System.out.println("TestT loaded");};
	public TestT() {
		System.out.println("TestT constructed");
	}
	public void prin() {
		System.out.println("Test printline");
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

	

}
