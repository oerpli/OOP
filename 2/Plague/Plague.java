package Plague;

public class Plague {
	
	static double[] Plague = new double[1];
	public static double getPlague()
	{
		Plague[0]=0.4;
		Plague[1]=0.6;
		System.out.println(Plague[1]+" "+Plague[0]);
		if(Math.random()>0.5) return choose();
		else return 0;
	}
	
	private static double choose(){
		System.out.println(Plague[1]+" "+Plague[0]);
		if(Math.random()>0.5) return Plague[0];
		else return Plague[1];
	}
	
}
