import java.util.HashMap;

public class HotToddy extends CocktailHot {
        public static final String name = "HotToddy";
        protected static final HashMap<String, Integer> reference = new HashMap<>();
        static {
                reference.put("Gin", 10);
                reference.put("Zitronensaft", 100);
        }
        public HotToddy(String N) {
                super(N);
        }
		@Override
		protected int getTemp() {
			return 50;
		}

}