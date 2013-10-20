package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;

public class Weed implements Tasks {

	@Override
	public int expenditure() {
		return 2;
	}

	@Override
	public void execute(User u, Pot p) {
		p.weed();
	}
}
