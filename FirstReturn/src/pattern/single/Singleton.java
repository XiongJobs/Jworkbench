package pattern.single;

//懒汉式单例类.在第一次调用的时候实例化自己   
public class Singleton {	
	 private static Singleton single=null;  
	 
	 private Singleton() {System.out.println("singleton create");}  
	 
	 public static void main(String args[]) {
		 Singleton sing=Singleton.getInstance3();
	 }
	 
	 //静态工厂方法   (加同步锁)
	 public static synchronized Singleton getInstance() {  
		 System.out.println("getInstance");
	     if (single == null) {    
	         single = new Singleton();  
	      }    
	      return single;  
	 }
	 
	 
	 //双重同步锁
	 public static Singleton getInstance2() {  
		 System.out.println("getInstance2");
	        if (single == null) {    
	            synchronized (Singleton.class) {    
	               if (single == null) {    
	            	   single = new Singleton();   
	               }    
	            }    
	        }    
	        return single;   
	 } 
	 //静态内部类
	 private static class LazyHolder {    
	       private static final Singleton INSTANCE = new Singleton();    
	 }       
	 public static final Singleton getInstance3() { 
		 	System.out.println("getInstance3");
	       return LazyHolder.INSTANCE;    	    
	 }  

}
