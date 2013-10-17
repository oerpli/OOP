class UserManager // Verwaltet alle Teilnehmer
{
	private HashMap<String,PumpManager> user;

	public UserManager()
	{
		user = new HashMap<String,PumpManager>();
	}
	
	public static String register()
	{
		PumpManager pm = new PumpManager();
		String userName = "Benutzername";
		
		pm.put(userName, pm);
	
		return userName;
	}
}
