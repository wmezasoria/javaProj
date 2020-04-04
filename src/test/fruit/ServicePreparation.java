package test.fruit;

import java.util.List;
import java.util.TreeMap;

import com.formos.entity.ExtraIngredients;
import com.formos.entity.Fruit;

public class ServicePreparation {

	public static void getDrink(String size, Integer flavor, List<Fruit> lFruit, List<ExtraIngredients> lExtra) {
		switch (size) {
		case "small":
			getPrepared(1, flavor, lFruit, lExtra);
			break;
		case "medium":
			getPrepared(2, flavor, lFruit, lExtra);
			break;
		case "large":
			getPrepared(3, flavor, lFruit, lExtra);
			break;
		default:
			break;
		}
	}

	private static void getPrepared(Integer n, Integer flavor, List<Fruit> lFruit, List<ExtraIngredients> lExtra) {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "strawberry");
		treeMap.put(2, "banana");
		treeMap.put(3, "mango");
		
		String flavorSelected = treeMap.get(flavor);
		
		for(Fruit fruit : lFruit) {
			;
			if (fruit.getName().equals("strawberry") && fruit.getName().equalsIgnoreCase(flavorSelected))
				fruit.setMass(fruit.getMass() - new Long(50));//por n para el tama�o
			else if (fruit.getName().equals("banana") && fruit.getName().equalsIgnoreCase(flavorSelected)) 
				fruit.setMass(fruit.getMass() - new Long(60));
			else if (fruit.getName().equals("mango") && fruit.getName().equalsIgnoreCase(flavorSelected))
				fruit.setMass(fruit.getMass() - new Long(70));
		}
		
		for(ExtraIngredients extra : lExtra) {
			if (extra.getName().equalsIgnoreCase("ice"))
				extra.setVolumen(extra.getVolumen() - new Long(30));//por n para el tama�o
			else if (extra.getName().equalsIgnoreCase("milk"))
				extra.setVolumen(extra.getVolumen() - new Long(20));
			else if (extra.getName().equalsIgnoreCase("sugar"))
				extra.setVolumen(extra.getVolumen() - new Long(8));//in fact is mass
		}
		
	}

}
