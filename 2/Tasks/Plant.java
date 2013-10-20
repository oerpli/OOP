package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;
import Main.UserManager;

public class Plant implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public void execute(User u, Pot p) {
		UserManager.plantPot(u, p);
		Pot.plant(p);
	}
}
