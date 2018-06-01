package pattern.observer;

public class Test {
	public static void main(String[] args) {
	      //  new Dad(new Child());
		
		 new Thread(new Child2(new Dad2())).start();
	}
}
