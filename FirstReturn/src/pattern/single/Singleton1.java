package pattern.single;

public class Singleton1 {
	//����ʽ������.�����ʼ��ʱ���Ѿ�����ʵ����  
	private Singleton1() {System.out.println("singleton1 create");}  
    private static final Singleton1 single = new Singleton1();  
    
    //��̬��������   
    public static Singleton1 getInstance() {  
        return single;  
    }
    
    public void sinprin() {
    	System.out.println("singleton print");
    }
    public static void main(String args[]) {
    	Singleton1.getInstance().sinprin();
    }
}
