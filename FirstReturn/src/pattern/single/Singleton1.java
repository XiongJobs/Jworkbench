package pattern.single;

public class Singleton1 {
	//饿汉式单例类.在类初始化时，已经自行实例化  
	private Singleton1() {System.out.println("singleton1 create");}  
    private static final Singleton1 single = new Singleton1();  
    
    //静态工厂方法   
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
