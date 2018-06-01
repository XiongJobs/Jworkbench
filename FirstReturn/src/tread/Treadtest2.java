package tread;

public class Treadtest2 {

	public static void main(String[] args) {
		MyThread2 t=new MyThread2("t2");
		t.start();
		try {
			t.join(); //将t线程合并到主线程
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=1;i<=5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main thread");
		}
	}
	
}

class MyThread2 extends Thread{
	MyThread2(String s){
		super(s);
	}
	
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("Is tread "+getName());
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

