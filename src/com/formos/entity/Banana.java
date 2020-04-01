package com.formos.entity;

public class Banana extends Fruit {
	
	public Banana() {
		super();
		this.mass = new Double(120);//gr necessary 
		this.volumen = new Double(100);//ml that obtain 
		this.name = "banana";
	}
	
	
	public Banana(Double mass, Double volumen) {
		super();
		this.mass = mass;
		this.volumen = volumen;
	}
	
	
}
