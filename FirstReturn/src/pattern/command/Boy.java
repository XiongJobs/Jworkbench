package pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	private String name;
	List<Comand> lis =new ArrayList<Comand>();
	
	public Boy() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Comand> getLis() {
		return lis;
	}

	public void setLis(List<Comand> lis) {
		this.lis = lis;
	}
	
	public void adcommand(Comand c) {
		lis.add(c);
	}
	
	public void dosomething() {
		if(lis.size()>0) {
			List<Comand> li=this.getLis();
			for(Comand co:li) {
				co.execute();
			}
		}else {
			System.out.println("there has no command");
		}
	}
}
