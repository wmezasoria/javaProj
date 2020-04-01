package com.formos.entity;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class Drink {
	private Double volumen = null;
	private Float price = null;
	private Fruit fruit = null;

	public Drink(Fruit fruit) {
		super();
		this.fruit = fruit;
	}

	/**
	 * @return the volumen
	 */
	public Double getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the fruit
	 */
	public Fruit getFruit() {
		return fruit;
	}

	/**
	 * @param fruit the fruit to set
	 */
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

}
