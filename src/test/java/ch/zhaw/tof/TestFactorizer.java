package ch.zhaw.tof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

import junit.framework.TestCase;

public class TestFactorizer extends TestCase {

	Set<PrimeGenerator> generators = new HashSet<PrimeGenerator>();

	public TestFactorizer(String name) {
		super(name);

	}

	@Override
	protected void setUp() throws Exception {

	}

	public void testFactors() {

		int[] nullArray = PrimeFactorizer.factor(0);
		assertEquals(nullArray.length, 0);
		
		int[] oneArray = PrimeFactorizer.factor(1);
		assertEquals(oneArray.length, 0);

		int[] minArray = PrimeFactorizer.factor(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);

		int[] tenArray = PrimeFactorizer.factor(10);
		assertEquals(tenArray.length, 2);
		assertArrayEquals(new int[]{2,5}, tenArray);
		
		int[] arr = PrimeFactorizer.factor(120);
		assertArrayEquals(new int[]{2, 2, 2, 3, 5}, arr);
	}
}
