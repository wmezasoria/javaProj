package com.test.fruit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.formos.entity.ExtraIngredients;
import com.formos.entity.Fruit;

public class Main {

	// public Main() {
	// // TODO Auto-generated constructor stub
	// }
	
	static Fruit strawberry = new Fruit("strawberry", new Long(1));
	static Fruit banana = new Fruit("banana", new Long(1));
	static Fruit mango = new Fruit("mango", new Long(1));
    static List<Fruit> lFruitInventary = new ArrayList<Fruit>();
    
    static ExtraIngredients ice = new ExtraIngredients("ice", new Long(1000));
	static ExtraIngredients milk = new ExtraIngredients("milk", new Long(1000));
	static ExtraIngredients sugar = new ExtraIngredients("sugar", new Long(1000));
    static List<ExtraIngredients> lExtraInventary = new ArrayList<ExtraIngredients>();
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		int option;
		int flavor = 0;
		
		lFruitInventary.add(strawberry);
		lFruitInventary.add(banana); 
		lFruitInventary.add(mango);
		
		lExtraInventary.add(ice);
		lExtraInventary.add(milk); 
		lExtraInventary.add(sugar);
		
		
		// String FLAVOR[] = {"Strawberry", "Banana", "Mango"};

		while (!exit) {

			System.out.println("1. Sell");
			System.out.println("2. Inventory");
			System.out.println("3. Opcion 3");
			System.out.println("4. Exit");

			try {
				System.out.println("Choose an option");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					// set inventory
					
					// set 300 ml
					// flavor
					
					 System.out.println("Choose a flavor\n");
					 System.out.println("1. Strawberry");
					 System.out.println("2. Banana");
					 System.out.println("3. Mango");
					 flavor = scanner.nextInt();
					 
					 ServicePreparation.getDrink("small", flavor, lFruitInventary, lExtraInventary);

					// get prepared
//					for (int i = 1; i <= 3; i++)
//						getPrepared();
					// inventory update
					// System.out.print("\033[H\033[2J");
					// System.out.flush();
					break;
				case 2:
					System.out.println("Has seleccionado la opcion 2");
					inventoryReport();
					break;
				case 3:
					System.out.println("Has seleccionado la opcion 3");
					break;
				case 4:
					System.out.println("\n\nBye");
					exit = true;
					break;
				default:
					System.out.println("Only 1 to 4");
				}
			} catch (InputMismatchException e) {
				System.out.println("You must enter a number");
				scanner.next();
			}
		}
	}



	private static void inventoryReport() {
		for(Fruit fruit : lFruitInventary) 
			System.out.println("\n "+fruit.getName() + " " + fruit.getMass());

		for(ExtraIngredients extra : lExtraInventary) 
			System.out.println("\n "+extra.getName() + " " + extra.getVolumen());
	}

//	private static void getPrepared() {
//		strawberry.setMass(strawberry.getMass() - new Long(50));
//	}

}
