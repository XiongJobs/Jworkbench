  package pattern.state;

public class MMHappyState extends MMState {

	public MMHappyState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void cry() {
		System.out.println("happy cry");
		
	}

	@Override
	void smile() {
		System.out.println("happy smile");
		
	}

	@Override
	void say() {
		System.out.println("happy say");
		
	}

}
