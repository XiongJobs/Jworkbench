package propertytest;

import java.io.IOException;
import java.util.Properties;

public class Test1 {

	public static void main(String[] args) {
		Properties props=new Properties();
		String age="";

		try {
			props.load(Test1.class.getClassLoader().
					getResourceAsStream("propertytest/person.properties"));
			age=props.getProperty("age");
			
			for(String key:props.stringPropertyNames()) {
				System.out.println(key +"="+props.getProperty(key));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(age);
	}

}
