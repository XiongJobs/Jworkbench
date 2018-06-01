package pattern.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask; 

public class Test1 {

	public static void main(String[] args) {
		
		
		String rt = "\r\n";
		String src = 
			"package pattern.compiler;" +  rt +
			"public class TankTimeProxy implements Moveable {" + rt +
			"    public TankTimeProxy(Moveable t) {" + rt +
			"        super();" + rt +
			"        this.t = t;" + rt +
			"    }" + rt +
			
			"    Moveable t;" + rt +
							
			"    @Override" + rt +
			"    public void move() {" + rt +
			"        long start = System.currentTimeMillis();" + rt +
			"        System.out.println(\"starttime:\" + start);" + rt +
			"        t.move();" + rt +
			"        long end = System.currentTimeMillis();" + rt +
			"        System.out.println(\"time:\" + (end-start));" + rt +
			"    }" + rt +
			"}";
		String fileName = System.getProperty("user.dir") 
							+ "/src/pattern/compiler/TankTimeProxy.java";
		File f = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write(src);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		try {
			fileMgr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//load into memory and create an instance
		URL[] urls;
		try {
			urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") +"/src")};
			URLClassLoader ul = new URLClassLoader(urls);
			Class c = ul.loadClass("pattern.compiler.TankTimeProxy");
			System.out.println(c);
			  
			Constructor ctr = c.getConstructor(Moveable.class);
			Moveable m = (Moveable)ctr.newInstance(new Tank());
			m.move();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
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
		}
		

	}

}
