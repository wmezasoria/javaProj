package com.test;

public class Shadow {

	static int x;

	public static void main(String[] args) {
		x = 5;
		System.out.println("x = " + x);
		int x;
		x = 10;
		System.out.println("x = " + x);
		System.out.println("ShadowApp.x = " + Shadow.x);
	}
}
