package tread;

public class AbPrint {

	public static void main(String[] args) {
		 Object printACon = new Object();
	     Object printBCon = new Object();
	     new Thread(new PrintA(printACon, printBCon)).start();
	     new Thread(new PrintB(printACon, printBCon)).start();


	}

}


class PrintA implements Runnable {
    private Object objectA = null;
    private Object objectB = null;

    PrintA(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }
    @Override
    public void run() {
        System.out.println("PrintA start......");
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printA print " + i);
        }

        try {
            // A�̴߳�ӡ����1��2��3��֪ͨ�߳̿�ʼ��ӡ��������ʼ�ȴ�
            synchronized(objectA) {
                synchronized(objectB) {
                    objectB.notify();
                }
                objectA.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PrintA reStart......");
        for (int i = 7; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printA print " + i);
        }
    }

}

class PrintB implements Runnable {
    private Object objectA = null;
    private Object objectB = null;

    PrintB(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }

    @Override
    public void run() {
        try {
            // �տ�ʼB�̵߳ȴ�A�̴߳�ӡ��1��2��3
            synchronized(objectB) {
                objectB.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PrintB start......");
        for (int i = 4; i < 7; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printB print " + i);
        }

        // B�̴߳�ӡ����4��5��6���֪ͨA�̼߳�����ӡ
        synchronized(objectA) {
            objectA.notify();
        }       
    }   
}