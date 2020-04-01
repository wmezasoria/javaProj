package com.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tech {

	public static void main(String[] args) {
		 
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int option; 
 
        while (!exit) {
 
            System.out.println("1. Sell");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                option = scanner.nextInt();
 
                switch (option) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                    	System.out.println("Bye");
                        exit = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next();
            }
        }
 
    }
	
//	public static void main(String[] args)
//    {
//        String nombre;
//
//        Scanner teclado = new Scanner(System.in);
//        System.out.print("Introduzca su nombre: ");
//        nombre = teclado.nextLine();
//        System.out.println("¡Hola " + nombre + "!");
//    }

	// public static void main(String[] args) {
	// int[][] a = {{0,0},{0,0}};
	// int[] numbers = {5,1,2,3,4,5};
	// Integer total = 0;
	// for (int i=0 ; i<=numbers.length-1; i++){
	// total = numbers[i]+total;
	//
	// }
	// System.out.println(total);
	// }

}
