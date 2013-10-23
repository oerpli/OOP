package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;

public class Poison implements Tasks {

	@Override
	public int expenditure() {
		return 2;
	}

	@Override
	public boolean execute(User u, Pot p) {
		p.usePoison(0.6);
		return true;
	}

}
