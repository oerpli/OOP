import Pumpkincontest.*;

import java.util.Random;

public class Test {
	private static double[][] testdata = new double[100][2];
	public static void main(String[] args) {
		
		
		testdata=createRandom(testdata);

		
		for(int i=0;i<100;i++)
		{
			if(testdata[i][0]==0 && testdata[i][1]==0)
			{
				testdata[i][1]=0.5;
				testdata[i][0]=0.5;
			}
			
		}
		
		Garten.pflanzen();
		for(int i=0;i<100;i++)
		{
			try {
				Garten.Tag((testdata[i][0]),testdata[i][1]);
			} catch (PumpkinException e) {
				
				e.printStackTrace();
			}			
		}
		
		System.out.println(Garten.String());

		
	}
	public static double[][] createRandom(double[][] testdata2)
	{	
	    Random random = new Random();
	    int randomNumber = random.nextInt(100);
	    
	    	for(int i=0;i<10;i++)//fill 10 water days
	    	{
	    		while(true)
	    		{
	    			randomNumber = random.nextInt(100);
	    			if(testdata2[randomNumber][1]==0 && testdata2[randomNumber][1]==0)
	    			{
	    				testdata2[randomNumber][1]=1;
	    				testdata2[randomNumber][0]=0;
	    				break;
	    			}
	    		}
	    	}
	    		
	    	for(int j=0;j<10;j++)//fill 10 light days
		    {
		    	while(true)
		    	{
		    		randomNumber = random.nextInt(100);
		    		if(testdata2[randomNumber][0]==0 && testdata2[randomNumber][1]==0)
		    		{
		    			testdata2[randomNumber][1]=0;
		    			testdata2[randomNumber][0]=1;
		    			break;
		    		}
		    	}
		    }
	    	
		return testdata2;
	}
}
