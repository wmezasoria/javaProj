package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CopyOfTest {
	// public static void main(String[] args) {
	// System.out.println("nombre: " +
	// Cabecera.class.getCanonicalName().contains("u"));
	// }

	// //////////////////////////////////////////

	// // determines the largest of three Comparable objects
	// public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
	// T max = x; // assume x is initially the largest
	// if (y.compareTo(max) > 0) {
	// max = y; // y is the largest so far
	// }
	// if (z.compareTo(max) > 0) {
	// max = z; // z is the largest now
	// }
	// return max; // returns the largest object
	// }
	//
	// public static void main(String args[]) {
	// System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3,
	// 4, 5));
	// System.out.printf("Maxm of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8,
	// 7.7, maximum(6.6, 8.8, 7.7));
	// System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple",
	// "orange", maximum("pear", "apple", "orange"));
	// }

	// ////////////////////////////////////////

	// generic method
	// public static <E> void printArray(E... inputArray) {
	// // Display array elements
	// for (E element : inputArray) {
	// System.out.printf("%s ", element);
	// }
	// System.out.println();
	// }
	//
	// public static void main(String args[]) {
	// // Create arrays of Integer, Double and Character
	// Integer[] intArray = { 1, 2, 3, 4, 5 };
	// Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	// Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
	//
	// System.out.println("Array integerArray contains:");
	// printArray(intArray); // pass an Integer array
	//
	// System.out.println("\nArray doubleArray contains:");
	// printArray(doubleArray); // pass a Double array
	//
	// System.out.println("\nArray characterArray contains:");
	// printArray(charArray); // pass a Character array
	// }
	// ////////////////////////////////////////
	// public static void main(String args[]) {
	// // create random object
	// Random randomno = new Random();
	//
	// // get next next boolean value
	// boolean value = randomno.nextBoolean();
	//
	// // check the value
	// System.out.println("Value is: " + value);
	// }
	// ////////////////////////////////////////

	// static int solveMeFirst(int a, int b) {
	// return a+b;
	// }
	//
	//
	// public static void main(String[] args) {
	// Scanner in = new Scanner(System.in);
	// int a;
	// a = in.nextInt();
	// int b;
	// b = in.nextInt();
	// int sum;
	// sum = solveMeFirst(a, b);
	// System.out.println(sum);
	// }

	// ////////////////////////////////////////

	public static void main(String[] args) {
		System.out.println(ThreadLocalRandom.current().nextInt(6, 10 + 1));
		System.out.println(new Random().nextInt(5));
	}
	// //////////////////////////////////////
//	public static void main(String[] args) {
//		String str = new String("Welcome to Tutoria ls--  --point.com");
//		System.out.println("extension es: " +str.split("\\.")[str.split("\\.").length-1]);
//		System.out.print("Return Value :");
//		System.out.println("replaceAll " + str.replaceAll("-", ""));
//		str = new String("1713580494");
//		System.out.println("StringBuilder insert " + new StringBuilder(str).insert(9, '-'));
//		str = new String("171358049&w");
//		System.out.println("StringTokenizer " + str + " nextToken " + new StringTokenizer(str, "&").nextToken());
//		System.out.println("count "+new StringTokenizer(str, "&").countTokens());
//	System.out.println("Pichincha - CJ".split("-")[1]);
	
//		String s = "1231A23aY%j";//"1713580494";//
//		Pattern pattern = Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);
//	    Matcher matcher = null;
//	    matcher = pattern.matcher(s);
//	    if (!matcher.find())
//	    	System.out.println("OK");
//	    else 
//	    	System.out.println("Special character in my string");
//	}
	
	
	
	
	
	
	
//	public static void main (String[] args) throws java.lang.Exception
//    {
//        SimpleDateFormat date = new SimpleDateFormat("dd-MMMM-yyyy", new Locale("es","ES"));
//        System.out.println(date.format(new Date()));
//    }

}
