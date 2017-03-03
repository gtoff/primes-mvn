package ch.zhaw.tof;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorizer {
	
	public static int[] factor(int multiple){
		PrimeGenerator pg = new GeneratePrimes();
		int[] primes = pg.generatePrimes(multiple);
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 0 ; i < primes.length && multiple != 1; i++ ){
			int factor = primes[i];
			while (multiple % factor == 0){
				multiple = multiple / factor;
				factors.add(factor);
			}
		}
		return factors.stream().mapToInt(i->i).toArray();
	}

}
