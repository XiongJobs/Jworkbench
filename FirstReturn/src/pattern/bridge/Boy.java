package pattern.bridge;

public class Boy {
	private String name;
	
	public Boy() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pursue(MM mm) {
		Gift g=new WarmGift(new Flower());
		give(g,mm);
	}
	
	public void give(Gift g,MM mm) {
		
	}
}
