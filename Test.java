/**
 * Prime factorization of two numbers in an n-dimensional space
 * Takes two numbers
 * Gives their prime factorization
 * Given a space in which each axis is represented by a prime factor
 * and the coordinate is the number of times that factor appears in the factorization
 * Returns the minimum dimensionality of the space required to graph two numbers
 * @author Amarto Rajaram
 */

import java.util.ArrayList;
import java.util.Collections;


public class Test 
{

	public static void main(String[] args) 
	{
		System.out.println(factorizePrime(19));
		System.out.println(factorizePrime(843));
		int min = minSpaceDim(factorizePrime(12), factorizePrime(72));
		System.out.println("The minimum space dim is " + min);
		

	}

	/**
	 * Checks if a number is prime
	 * @param n, the number
	 * @return true if prime, false if not
	 */
	public static boolean isPrime(int n)
	{
		if (n == 2)
			return true;
		if (n == 0 || n == 1 || n%2 == 0)
			return false;

	
			for (int i = 2; i < Math.sqrt(n); i++)
			{
				if(n%i == 0)
					return false;
			}	
		
		return true;
	}
	
	/**
	 * Finds prime factorization of a number
	 * @param n, the number
	 * @return an arraylist with all the prime factors of the number 
	 * i.e. 12 = 2, 2, 3
	 */
	public static ArrayList<Integer> factorizePrime(int n)
	{
		ArrayList<Integer> primeFactorization = new ArrayList<Integer>();
		
		if (isPrime(n))
		{
			primeFactorization.add(n);
			return primeFactorization;
		}

		for (int i = 2; i < Math.sqrt(n); i++)
		{
			if (n%i == 0 && isPrime(i))
			{
				if (isPrime(i))
				{
					primeFactorization.add(i);
					primeFactorization.addAll(factorizePrime(n/i));
				}	

				else
					primeFactorization.addAll(factorizePrime(i));	
			}				
		}	

		Collections.sort(primeFactorization);

		return primeFactorization;
	}
	
	/**
	 * get dimensionality of prime factorization
	 * @param a, the arraylist with the prime factorization
	 * @return counter, the number of unique dimensions, unique prime factors
	 */
	public static int getDim(ArrayList<Integer> a)
	{
			int counter = 1;
			for (int i = 1; i < a.size(); i++)
			{	
				if (a.get(i) != a.get(i-1))
					counter++;
			}

			return counter;	
	}
	 /**
	  * Get the minimum dimensionality required to represent the space
	  * @param a, prime factorization of first integer
	  * @param b, prime factorization of second integer
	  * @return dimensionality of the space
	  */
	public static int minSpaceDim(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		return Math.max(getDim(a), getDim(b));
	}
	
	public static int[][] getCoords(ArrayList<Integer> a)
	{
		int[][] coords = new int[getDim(a)][2];
		
//
//		int[] firstBuffer = new int[a.size()];
//		firstBuffer[0] = a.get(0);
//		for (int i = 1; i < a.size(); i++)
//		{	
//			if (a.get(i) != a.get(i-1))
//				firstBuffer[i] = a.get(i);
//		}
//
//		int counter = 0;
//		for (int i = 0; i < firstBuffer.length; i++)
//		{
//			counter++;
//			if (firstBuffer[i] == 0)
//				break;
//		}
//		int[] firstPrimes = new int[counter];
//		for (int i = 0; i < counter; i++)
//			firstPrimes[i] = firstBuffer[i];
//
//		int[] firstFreq = new int[counter];
//		int freqCounter = 0;
//		for (int i = 0; i < a.size();
//		{
//
//		
		return coords;
	}
	
}
