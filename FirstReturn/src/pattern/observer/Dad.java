package pattern.observer;

public class Dad implements Runnable {
    private Child c;
    public Dad(Child c) {
        new Thread(this).start();
        this.c = c;
    }
    
    @Override
    public void run() {
        while (!c.isWake()) {
            System.out.println("Dad:child is sleeping...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        feed(c);
    }
    private void feed(Child c2) {
        System.out.println("feed child!");
    }
}
