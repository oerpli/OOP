public class Test
{
	public static void main(String [] args)
	{
		String name = "Max";
	
		UserManager.register(name);

		User me = UserManager.getUser(name);
		me.plant(new Hokkaido(new SandSoil()));
		me.plant(new Patisson(new SandSoil()));
		
		me.fertilize(1); // Braucht die Nummer des eigenen Kürbisses.
		me.weed(0); // Braucht die Nummer des eigenen Kürbisses.
		me.water(1); // Braucht die Nummer des eigenen Kürbisses.
	}
}
