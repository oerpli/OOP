import Pumpkin.*;
import Soil.*;

public class Test
{
	public static void main(String [] args)
	{
		String name = "Max";
	
		UserManager.register(name);
		Time.register(name);
		User me = UserManager.getUser(name);
		me.plant(new Hokkaido(new SandSoil()));
		me.plant(new Patisson(new SandSoil()));
		
		me.fertilize(1); // Braucht die Nummer des eigenen Kürbisses.
		me.weed(0); // Braucht die Nummer des eigenen Kürbisses.
		me.water(1); // Braucht die Nummer des eigenen Kürbisses.
		
		me.skipDays(0, 5); // Kürbis 0 wird um fünf Tage älter ohne Pflege.
	}
}
