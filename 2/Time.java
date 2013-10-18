import java.util.HashMap;
import java.util.Map.Entry;

public class Time {

	private static HashMap<String, Integer> time;
	private static int maxTime;

	public Time(int maxTime) {
		time = new HashMap<String, Integer>();
		Time.maxTime=maxTime;
	}

	public static void register(String Username) {
		time.put(Username, new Integer(maxTime));
	}

	public boolean substractTime(String Username, int Time) {
		if (getTimeLeft(Username) >= Time && getTimeLeft(Username) > 0) {
			int oldValue = time.get(Username);
			time.put(Username, new Integer(oldValue - Time));
			return true;
		}
		return false;
	}

	public int getTimeLeft(String Username) {
		return time.get(Username);
	}

	public void nextDay() {
		for (Entry<String, Integer> entry : time.entrySet()) {

			String key = entry.getKey();
			substractTime(key, 1);
		}
	}
}
