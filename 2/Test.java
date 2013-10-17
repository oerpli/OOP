public class Test
{
	String userName = UserManager.register();
	System.out.println("Ihr Benutzername ist " + userName);
	
	PumpManager pm = UserManager.getUser(userName);
	pm.plant();
}
