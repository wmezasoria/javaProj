package com.formos.entity;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class Fruit {

	private Double massInventory = new Double(0);
	protected String name = null;
	protected Double mass = new Double(0);//g per Constant.UNIVERSAL
	protected Double volumen = new Double(0);//g per Constant.UNIVERSAL
	
	public Fruit(){
	}
	
	/**
	 * @param massInventory gr
	 */
	public Fruit(Double massInventory) {
		super();
		this.massInventory = massInventory;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the massInventory
	 */
	public Double getMassInventory() {
		return massInventory;
	}

	/**
	 * @param d the massInventory to set
	 */
	public void setMassInventory(double d) {
		this.massInventory = d;
	}

	/**
	 * @return the mass
	 */
	public Double getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(Double mass) {
		this.mass = mass;
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

}
