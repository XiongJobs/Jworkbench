package pattern.command;

public class HugCommand extends Comand {

	public HugCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("hug");
		
	}

	@Override
	public void undo() {
		System.out.println("undo hug");
		
	}

}
