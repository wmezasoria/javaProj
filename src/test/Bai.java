package com.test;

import java.util.HashMap;
import java.util.Map;

public class Bai {

	public static void main(String[] args) {

//		int[] intArray = new int[]{ 1,2,2,3,4,2,5,6,7,8,9,2,123 }; 
//		int a = 2, count =0;
//		for (int i = 0; i < intArray.length; i++) {
//			if(a==intArray[i])
//				count = count +1;
//			
//		}
//		
//		System.out.println("number "+a+" is "+count+" repeated");
		
//		double x1 = 5, y1 = 2;
//		double x2 = 2, y2 = 2;
//		double x3 = 2, y3 = 4;
//		double a=0,b=0,c = 0;
//		
//		a = Math.abs(x1-x2);
//		b = Math.abs(y3-y2);
//		c = Math.hypot(a, b);
//		
//		System.out.println("average distance is "+(a+b+c)/3);
		
		  
		  
//		        String str = "abccfg"; 
//		  
//		        if (isAlmostPalindrome(str)) 
//		            System.out.print("Yes"); 
//		        else
//		            System.out.print("No"); 
		
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10,1 }; 
		
		getValuator(intArray);
		
	}
	
	
	static int getValuator(int[] array){
		HashMap<Integer,Integer> counterMap = new HashMap<Integer, Integer>();

		for(int i=0;i<array.length;i++){
	         if(counterMap.containsKey(array[i])){
	          counterMap.put(array[i], counterMap.get(array[i])+1 );
	         }else{
	          counterMap.put(array[i], 1);
	         }
	    }
		
		return counterMap.get(0);
	}
	
//	static boolean isAlmostPalindrome(String str) 
//    { 
//		int flag = 0;
//  
//        int i = 0, j = str.length() - 1; 
//  
//        while (i < j) { 
//  
//            if (str.charAt(i) != str.charAt(j) && flag == 0)
//            	flag = flag +1;
//            else if (str.charAt(i) != str.charAt(j) && flag == 1) 
//                return false; 
//  
//            i++; 
//            j--; 
//        } 
//  
//        return true; 
//    } 

}
