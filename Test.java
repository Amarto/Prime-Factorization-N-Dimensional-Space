import java.util.ArrayList;
import java.util.Collections;


public class Test 
{

	public static void main(String[] args) 
	{
		int min = minSpaceDim(factorizePrime(72), factorizePrime(84));
		System.out.println("The minimum space dim is " + min);
		

	}

	public static boolean isPrime(int n)
	{
		if (n == 0 || n == 1)
			return false;

		if (n%2 != 0)
		{
			for (int i = 0; i < Math.sqrt(n); i++)
			{
				if(i != 1 &&  n%i == 0)
					return false;
			}	
		}
		return true;
	}
	
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
					primeFactorization.add(i);

				else
					primeFactorization.addAll(factorizePrime(i));	
			}				
		}	

		Collections.sort(primeFactorization);

		return primeFactorization;
	}
	
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
	
	public static int minSpaceDim(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		return Math.max(getDim(a), getDim(b));
	}
	
}