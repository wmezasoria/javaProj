package com.formos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import com.formos.entity.Banana;
import com.formos.entity.Drink;
import com.formos.entity.ExtraIngredients;
import com.formos.entity.Fruit;
import com.formos.entity.Mango;
import com.formos.entity.Strawberry;
import com.formos.service.BusinessPortionRecipe;
import com.formos.util.Constant;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 * 
 *  lightweight application allows a street vendor to sell blended fruit drinks and track her inventory of ingredients
 */
public class Main {
	static Fruit strawberry = new Strawberry();
	static Fruit banana = new Banana();
	static Fruit mango = new Mango();
	static List<ExtraIngredients>lExtraInventary = new ArrayList<ExtraIngredients>();
	static Double n = new Double(3);//multiple of 100
	static Double volumeCup = new Double(0);
	static TreeMap<Integer, Double> treeMap = new TreeMap<Integer, Double>();

	/**
	 * @param args
	 * 
	 * principal fuction to run
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		int option;
		int flavor = 0;
		int sizeOption = 1;//by default is SMALL size
		Fruit fruit = new Fruit();
		
		

		setInitialInventory();
		while (!exit) {
			System.out.println("1. Inventory");
			System.out.println("2. Size");
			System.out.println("3. Sell");
			System.out.println("4. Exit");

			try {
				System.out.println("Choose an option");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					inventoryReport();
					break;
				case 2:
					System.out.println("Choose a size\n");
					System.out.println("1. Small");
					System.out.println("2. Medium");
					System.out.println("3. Large");
					sizeOption = scanner.nextInt();
					volumeCup = treeMap.get(sizeOption);
					System.out.println(volumeCup);
					break;
				case 3:
					System.out.println("Choose a flavor\n");
					System.out.println("1. Strawberry");
					System.out.println("2. Banana");
					System.out.println("3. Mango");
					flavor = scanner.nextInt();
					
					if (flavor == 1)
						fruit = new Strawberry();
					else if (flavor == 2)
						fruit = new Banana();
					else if (flavor == 3)
						fruit = new Mango();
					try {
						getBeverage(fruit);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("\n\nBye");
					exit = true;
					break;
				default:
					System.out.println("Only 1 to 3");
				}
			} catch (InputMismatchException e) {
				System.out.println("You must enter a number");
				scanner.next();
			}

		}

	}

	/**
	 * @param fruit
	 * @throws Exception 
	 * 
	 * function to prepare a beverage and update inventory
	 */
	private static void getBeverage(Fruit fruit) throws Exception {
		Double portionFruit = new Double(0);
		Double portionIce = new Double(0);
		Double portionMilk = new Double(0);
		Double portionSugar = new Double(0);
		Drink drink = new Drink(fruit);

//		drink.setVolumen(new Double(n * Constant.TOTAL_VOLUMEN_RECIPE));
		drink.setVolumen(volumeCup.equals(new Double(0))?treeMap.get(1):volumeCup);
		portionFruit = BusinessPortionRecipe.getPrepared(drink);
		portionIce = BusinessPortionRecipe.getPreparedIce(drink);
		portionMilk = BusinessPortionRecipe.getPreparedMilk(drink);
		portionSugar = BusinessPortionRecipe.getPreparedSugar(drink);
		
		//update the inventory fruit
		if (drink.getFruit().getName().equalsIgnoreCase("strawberry")) {
			if (strawberry.getMassInventory() - portionFruit <= 0) 
				throw new Exception("Insufficent inventory for "+fruit.getName());
			strawberry.setMassInventory(strawberry.getMassInventory() - portionFruit);
		}else if (drink.getFruit().getName().equalsIgnoreCase("banana")) {
			if (banana.getMassInventory() - portionFruit <= 0) 
				throw new Exception("Insufficent inventory for "+fruit.getName());
			banana.setMassInventory((banana.getMassInventory() - portionFruit)); 
		}else if (drink.getFruit().getName().equalsIgnoreCase("mango")) {
			if (mango.getMassInventory() - portionFruit <= 0) 
				throw new Exception("Insufficent inventory for "+fruit.getName());
			mango.setMassInventory(mango.getMassInventory() - portionFruit);
		}

		//update the inventory extras
		for (ExtraIngredients e : lExtraInventary) {
			if(e.getName().equalsIgnoreCase("ice"))
				e.setVolumen(e.getVolumen() - portionIce);
			else if(e.getName().equalsIgnoreCase("milk"))
				e.setVolumen(e.getVolumen() - portionMilk);
			else if(e.getName().equalsIgnoreCase("sugar"))
				e.setVolumen(e.getVolumen() - portionSugar);
		}
	}

	/**
	 * function to print ingredients inventory
	 */
	private static void inventoryReport() {
		System.out.println("strawberry " + strawberry.getMassInventory());
		System.out.println("banana " + banana.getMassInventory());
		System.out.println("mango " + mango.getMassInventory());
		
		for(ExtraIngredients extra : lExtraInventary) 
			System.out.println(extra.getName() + " " + extra.getVolumen());
	}

	/**
	 * set initial inventory for ingredients
	 */
	private static void setInitialInventory() {
		strawberry.setMassInventory(new Long(1000));// inventory
		banana.setMassInventory(new Long(1000));// inventory
		mango.setMassInventory(new Long(1000));// inventory
		
		ExtraIngredients ice = new ExtraIngredients("ice", new Double(1000));
		ExtraIngredients milk = new ExtraIngredients("milk", new Double(1000));
		ExtraIngredients sugar = new ExtraIngredients("sugar", new Double(1000));
		
		lExtraInventary.add(ice);
		lExtraInventary.add(milk);
		lExtraInventary.add(sugar);
		
		treeMap.put(1, Constant.SMALL);
		treeMap.put(2, Constant.MEDIUM);
		treeMap.put(3, Constant.LARGE);
	}

}
