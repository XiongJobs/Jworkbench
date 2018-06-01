package pattern.single;

//����ʽ������.�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�   
public class Singleton {	
	 private static Singleton single=null;  
	 
	 private Singleton() {System.out.println("singleton create");}  
	 
	 public static void main(String args[]) {
		 Singleton sing=Singleton.getInstance3();
	 }
	 
	 //��̬��������   (��ͬ����)
	 public static synchronized Singleton getInstance() {  
		 System.out.println("getInstance");
	     if (single == null) {    
	         single = new Singleton();  
	      }    
	      return single;  
	 }
	 
	 
	 //˫��ͬ����
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
	 //��̬�ڲ���
	 private static class LazyHolder {    
	       private static final Singleton INSTANCE = new Singleton();    
	 }       
	 public static final Singleton getInstance3() { 
		 	System.out.println("getInstance3");
	       return LazyHolder.INSTANCE;    	    
	 }  

}
