package pattern.state;

public class MM {

	private String name;
	private MMState st=new MMHappyState();
	
	public MM() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void cry() {
		st.cry();
	}
	
	public void smile() {
		st.smile();
	}
	
	public void say() {
		st.say();
	}
	
}
