package reflectstu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Mainpro {
	
	public static void main(String[] args) {
		Class cl=Car.class;
		Class ca=new Car().getClass();
		
		Class clz3 = new int[]{}.getClass();

/*		System.out.println(clz3.getName());
		System.out.println(ca.getSimpleName());
		System.out.println(ca.getCanonicalName());
		System.out.println(cl.getModifiers());  //返回修饰符代表数字
		System.out.println(Modifier.toString(cl.getModifiers()));*/
		
/*		Field[] fis=cl.getFields();
		Field[] dfis=cl.getDeclaredFields();
		for(Field f:fis) {
			System.out.println(f.getName()+" ff");
		}
		for(Field df:dfis) {
			System.out.println(df.getName());
		}*/
		
		try {
			Method cf=cl.getMethod("drive", null);
			cf.invoke(new Car(), null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
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
		}
	}
}
