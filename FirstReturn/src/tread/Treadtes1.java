package tread;

public class Treadtes1 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner r=new Runner();
	//	r.run();
		
/*		Thread t=new Thread(r);
		t.start();*/
		
		r.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main: "+i);
		}
	}

}
//class Runner implements Runnable{
  class Runner extends Thread{
	public void run() {
		for (int i=0;i<10;i++) {
			System.out.println("Runner: "+i);
		}
	}
}