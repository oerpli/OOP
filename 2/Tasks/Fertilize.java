package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;

public class Fertilize implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public boolean execute(User u, Pot p) {
		p.fertilize(0.6);
		return true;
	}

}
