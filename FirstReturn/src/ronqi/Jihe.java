package ronqi;

import java.util.ArrayList;
import java.util.Iterator;

public class Jihe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("hello");
		list.add("collection");
		list.add("7");
		System.out.println(list);
		Iterator<String> itor=list.iterator();
		
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
	}

}
