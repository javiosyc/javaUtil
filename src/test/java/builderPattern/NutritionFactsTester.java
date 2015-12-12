package builderPattern;

import org.junit.Test;

public class NutritionFactsTester {

	@Test
	public void builder() {

		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
			     calories(100).sodium(35).carbohydrate(27).build();
		System.out.println(cocaCola.getServingSize());
	}
}
