package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;
import Main.ContestManager;

public class Harvest implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public boolean execute(User u, Pot p) {
		return p.harvest();
	}
}
