package pattern.command;


public class ShoppyingCommand extends Comand {
	
	public ShoppyingCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("go shoppying");
		
	}

	@Override
	public void undo() {
		System.out.println("undo shoppying");
		
	}



}
