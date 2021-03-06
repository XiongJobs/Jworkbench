package pattern.observer;

import java.util.Random;

public class Child2 implements Runnable {
    public static Random r = new Random();
    private Dad2 d;
    private boolean wake = false;
   
    public Child2(Dad2 d) {
        this.d = d;
    }
    
    @Override
    public void run() {
        while (!wake) {
            System.out.println("Child2:I am sleeping...");
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
        d.feed(this);
    }
    public boolean isWake() {
        return wake;
    }
}
