package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;

public class Water implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public void execute(User u, Pot p) {
		p.waterize();
	}
}
