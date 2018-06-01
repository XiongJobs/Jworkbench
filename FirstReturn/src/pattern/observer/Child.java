package pattern.observer;

import java.util.Random;

public class Child implements Runnable{
	 	public static Random r = new Random();
	    private boolean wake = false;
	    public Child() {
	        new Thread(this).start();
	    }
	    @Override
	    public void run() {
	        while (!wake) {
	            System.out.println("Child:I am sleeping...");
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            if (r.nextInt(10) > 8) {
	                wakeUp();
	            }
	        }
	    }
	    public void wakeUp() {
	        wake = true;
	    }
	    public boolean isWake() {
	        return wake;
	    }
}
