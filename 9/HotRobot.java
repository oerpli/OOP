public class HotRobot {
	
	public void heatup(int temp,CocktailHot cocktail){
		assert temp >= 0 && temp < 100;
		cocktail.temperature=temp;
	}

}
