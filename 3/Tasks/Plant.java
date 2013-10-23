package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;
import Main.ContestManager;

public class Plant implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public boolean execute(User u, Pot p) {
		u.addPot(p);
		ContestManager.addPotToUser(u, p);
		Pot.plant(p);
		return true;
	}
}
