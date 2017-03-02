package ch.zhaw.tof;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

import org.reflections.Reflections;

import junit.framework.TestCase;

public class TestGeneratePrimes extends TestCase {

	Set<PrimeGenerator> generators = new HashSet<PrimeGenerator>();

	public TestGeneratePrimes(String name) {
		super(name);

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Reflections reflections = new Reflections("ch.zhaw.tof");
		Set<Class<? extends PrimeGenerator>> subTypes = reflections.getSubTypesOf(PrimeGenerator.class);
		for (Class<? extends PrimeGenerator> type : subTypes) {
			generators.add(type.getConstructor().newInstance());
		}
	}

	public void testPrimes() {
		for (PrimeGenerator pg : generators) {
			System.out.println("Testing " + pg.getClass());
			int[] nullArray = pg.generatePrimes(0);
			assertEquals(nullArray.length, 0);

			int[] minArray = pg.generatePrimes(2);
			assertEquals(minArray.length, 1);
			assertEquals(minArray[0], 2);

			int[] threeArray = pg.generatePrimes(3);
			assertEquals(threeArray.length, 2);
			assertEquals(threeArray[0], 2);
			assertEquals(threeArray[1], 3);

			int[] centArray = pg.generatePrimes(100);
			assertEquals(centArray.length, 25);
			assertEquals(centArray[24], 97);
		}
	}
}
