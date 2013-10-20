package Tasks;

import Interfaces.Tasks;
import Main.Pot;
import Main.User;
import Main.UserManager;

public class Harvest implements Tasks {

	@Override
	public int expenditure() {
		return 1;
	}

	@Override
	public void execute(User u, Pot p) {
		p.harvest();
		// Im UserManager auch noch entfernen oder so.
		// keine Ahnung wie genau.
	}
}
