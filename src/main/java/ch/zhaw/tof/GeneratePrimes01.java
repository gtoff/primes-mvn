package ch.zhaw.tof;

/**
 * This class Generates prime numbers up to a user specified maximum.
 * the algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria.  The first man to calculate the circumference
 * of the Earth.  Also known for working on calendars with leap
 * years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple.  Given an array of integers starting
 * at 2.  Cross out all multiples of 2.  Find the next uncrossed
 * integer, and cross out all of its multiples.  Repeat until
 * you have passed the square root of the maximum value.
 * 
 * @author Robert C. Martin
 * @version 9 Dec 1999 rcm
 */
import java.util.*;

/**
 * Class declaration
 * 
 * 
 * @author Robert C. Martin, G. Toffetti
 * @version %I%, %G%
 */
public class GeneratePrimes01 implements PrimeGenerator {
	/**
	 * @param maxValue
	 *            is the generation limit.
	 */
	public int[] generatePrimes(int maxValue) {
		if (maxValue >= 2) // the only valid case
		{
			// initialize array and run sieve
			boolean[] primePositions = runSieve(maxValue);
			return convertPositionsToNumbers(primePositions); // return the primes
		} else // maxValue < 2
			return new int[0]; // return null array if bad input.
	}

	public static boolean[] runSieve(int maxValue) {
		// declarations
		int s = maxValue + 1; // size of array
		boolean[] f = new boolean[s];
		int i;

		// initialize array to true.
		for (i = 0; i < s; i++)
			f[i] = true;

		// get rid of known non-primes
		f[0] = f[1] = false;

		// sieve
		int j;
		for (i = 2; i < Math.sqrt(s) + 1; i++) {
			for (j = 2 * i; j < s; j += i)
				f[j] = false; // multiple is not prime
		}
		return f;
	}

	public static int[] convertPositionsToNumbers(boolean[] primePositions) {
		// how many primes are there?
		int count = 0;
		for (int i = 0; i < primePositions.length; i++) {
			if (primePositions[i])
				count++; // bump count.
		}

		int[] primes = new int[count];

		// move the primes into the result
		for (int i = 0, j = 0; i < primePositions.length; i++) {
			if (primePositions[i]) // if prime
				primes[j++] = i;
		}
		
		return primes;
	}

}
