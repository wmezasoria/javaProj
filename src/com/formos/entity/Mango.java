package com.formos.entity;

public class Mango extends Fruit {
	
	
	public Mango() {
		super();
		this.mass = new Double(140);//gr neccesary
		this.volumen = new Double(100);//ml that obtain
		this.name = "mango";
	}
	
	public Mango(Double mass, Double volumen) {
		super();
		this.mass = mass;
		this.volumen = volumen;
	}
	
	
}
