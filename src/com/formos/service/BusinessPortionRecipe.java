package com.formos.service;

import com.formos.entity.Drink;
import com.formos.util.Constant;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public final class BusinessPortionRecipe {
	private static Double totalVolumen = Constant.TOTAL_VOLUMEN_RECIPE;//ml of a glass
	private static Double blendedFruit = new Double(50);//ml per UNIVERSAL_VOLUMEN
	private static Double ice = new Double(30);//ml per UNIVERSAL_VOLUMEN
	private static Double milk = new Double(20);//ml per UNIVERSAL_VOLUMEN
	private static Double sugar = new Double(8);//g per UNIVERSAL_VOLUMEN
	
	public static final Double blendedFruitPortion = blendedFruit/totalVolumen;//ml
	public static final Double icePortion = ice/totalVolumen;//ml
	public static final Double milkPortion = milk/totalVolumen;//ml
	public static final Double sugarPortion = sugar/totalVolumen;//g
	
	
	
	/**
	 * @param drink
	 * @return
	 */
	public static Double getPrepared(Drink drink) {
		return (drink.getFruit().getMass() * BusinessPortionRecipe.blendedFruitPortion) * (drink.getVolumen() / drink.getFruit().getVolumen());
	}
	
	/**
	 * @param drink
	 * @return
	 */
	public static Double getPreparedIce(Drink drink) {
		return BusinessPortionRecipe.icePortion * drink.getVolumen();
	}
	
	/**
	 * @param drink
	 * @return
	 */
	public static Double getPreparedMilk(Drink drink) {
		return BusinessPortionRecipe.milkPortion * drink.getVolumen();
	}
	
	/**
	 * @param drink
	 * @return
	 */
	public static Double getPreparedSugar(Drink drink) {
		return BusinessPortionRecipe.sugarPortion * drink.getVolumen();
	}
}
