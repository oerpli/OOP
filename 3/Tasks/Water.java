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
	public boolean execute(User u, Pot p) {
		p.waterize(0.4);
		return true;
	}
}
