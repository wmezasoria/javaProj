package prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class Principal {
	/**
	 * @param numero
	 * @param kPrecision
	 * @return
	 */
	public static boolean esPrimo(BigInteger numero, int kPrecision) {
		int r = 0;
		BigInteger d = numero.subtract(BigInteger.ONE);//inicializa d = n-1
		BigInteger a = null;
		BigInteger x = null;	
		
		if (numero.equals(BigInteger.ZERO) || numero.equals(BigInteger.ONE))//0 y 1 are specials, not composed neither primes
			return false;
		else if (numero.equals(new BigInteger("2")) || numero.equals(new BigInteger("3")) || numero.equals(new BigInteger("5")) || numero.equals(new BigInteger("7")))
			return true;
		//n-1 = 2^r*d
		while (d.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {//solo cdo d sea par
			r++;
			d = d.divide(new BigInteger("2"));//mitad a nroMenosUno
		}
		for (int i = 1; i <= kPrecision; i++) {//witnessloop hasta precision veces
			a = getRandom(new BigInteger("2"), numero.subtract(BigInteger.ONE));
			x = a.modPow(d, numero);
			if (x.equals(BigInteger.ONE) || x.equals(numero.subtract(BigInteger.ONE)))
				continue;//va al witnessloop
			for (int j = 0; j <= r-1; j++) {
				x = x.modPow(new BigInteger("2"), numero);
				if (x.equals(BigInteger.ONE))
					return false;// no es primo, es composite
				if (x.equals(numero.subtract(BigInteger.ONE)))
					continue; //va al witnessloop
			}
			return false;// no es primo, es composite
		}
		return true;//probablemente es primo
	}

	/**
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	private static BigInteger getRandom(BigInteger minimo, BigInteger maximo) {
		Random random = new Random();
		BigInteger res;
		do {
			res = new BigInteger(maximo.bitLength(), random);
		} while (res.compareTo(minimo) < 0 || res.compareTo(maximo) > 0);//debe estar dentro del rango de min max
		return res;
	}
	
	/**
	 * wmeza 29 de marzo
	 * basado en teorema de Fermat Miller-Rabin
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the number: ");
		BigInteger numero = scanner.nextBigInteger();
		System.out.println("Type the accuracy: ");
		int accuracy = scanner.nextInt();
		
		System.out.println("does the  number " + numero + " prime ? "+esPrimo(numero, accuracy));
	}
	

}
