package Main;

import java.math.*;

import Log.Log;
/**
 * Stellt Wetterdaten pro Tag bereit.
 */
class Weather {
	static double light = 0;
	static double lightTime = -1;
	static double[][] forecast=new double[24][5];
	static double[][] retrospect=new double[72][5];

	public static int getSunHours(int time) {
		int sunHours=0;
		for(int i=time;i<time+24;i++)
		{
			if(getLight()>0) sunHours+=1;
		}
		return sunHours;
	}

	public static double getRain(int time) {
		return calcRain(time);
	}

	public static double getMinTemp(int time) {
		return time;
	}

	public static double getMaxTemp(int time) {
		return time;
	}

	public static double getLight(int x) {
		double rotation = Math.max(0, Math.sin(Math.PI * x / 12));
		double ecliptic = Math.sin(x / 24 / 365 * 2 * Math.PI);
		return Math.cos(Math.PI / 4 + 0.4 * ecliptic) * rotation;
	}

	public static double getLight() {
		int x = Time.getTime();
		if (x > lightTime) {
			light = getLight(Time.getTime());
		}
		return light;
	}

	public static int getSunHours() {
		return getSunHours(Time.getTime());
	}

	public static double getRain() {
		return calcRain(Time.getTime());
	}

	public static double getMinTemp() {
		return 0;
	}

	public static double getMaxTemp() {
		return 0;
	}

	public static boolean isRaining() {
		return calcRain(Time.getTime())>0.5;
	}
	
	public static double calcRain(int w)
	{
		double rain=Math.sin(2*Math.PI/24/5*w+5);
		if(rain<0) rain=0;
		return rain;
		
	}
	
	public static double calcClouds(int w)
	{
		double clouds=Math.sin(2*Math.PI/24/5*w);
		if(clouds<0) clouds=0;
		return clouds;
	}
	
	public static void debug()
	{
		System.out.println("sonnenstunden: "+getSunHours(0));
		if(Log.debug > 2) System.out.println(getRain()+" "+isRaining()+" "+getLight());
	}

}
