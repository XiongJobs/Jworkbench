package pattern.command;

public class MM {
	private String name;
	
	public MM() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void order(Boy b) {
		Comand c=new ShoppyingCommand();
		b.adcommand(c);
		c=new HugCommand();
		b.adcommand(c);
		
		b.dosomething();
	}
	

}
