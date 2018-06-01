package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Flection1 {

	public static void main(String[] args) {
		TestT t=null;
		String str="reflection.TestT";
		
		try {
			Class cs=Class.forName(str);
			t=(TestT) cs.getDeclaredConstructor().newInstance();
			
			Method[] ms=cs.getMethods();
			for(Method m:ms) {
			//	System.out.println("method "+m.getName());
				if(m.getName().equals("prin")) {
					m.invoke(t);
				}else if(("setI").equals(m.getName())) {
					for(Class paramType : m.getParameterTypes()) {
						System.out.println(paramType.getName());
					}
				}else if("getS".equals(m.getName())) {
					Class retunType =m.getReturnType();
					System.out.println(retunType.getName());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
