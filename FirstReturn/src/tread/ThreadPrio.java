package tread;

public class ThreadPrio {

	public static void main(String[] args) {
		Thread  t1=new Thread(new T1());
		Thread  t2=new Thread(new R2());
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();

	}

}
class T1 implements Runnable{
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("T1: "+i);
		}
	}
}
class R2 implements Runnable{
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("R2: "+i);
		}
	}
}