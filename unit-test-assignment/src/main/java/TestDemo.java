//Last edited by Boris Goetz on 12-18-2021 @17:01
import java.util.Random;
import com.google.common.annotations.VisibleForTesting;

/**
 * reference: https://github.com/DrOldGuy/cohort_915_mysql-week-6.git
 */


public class TestDemo {

	Random random = new Random();

	/** method add positive
	 * the purpose of this method is to run a test on this method and demonstrates how parameterized test works
	 * this method accepts two integers a and b checked if they're both positive. If they are, it returns the sum of a and b.
	 * If at least one of them is negative, throw an illegal argument exception
	 * 
	 */
	public int addPositive(int a, int b) {
		System.out.println(random);
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("The parameters must be positive!");
		}
		return a + b;
	}

	public int randomNumberSquared() {
		int ar = getRandomInt();

		return ar * ar;
	}

	/**
	 * This generates a random number from zero to nine. It is package access so
	 * that a test can mock the method. See the test class for details.
	 * 
	 * @return The random number
	 */
	@VisibleForTesting
	int getRandomInt() {

		return random.nextInt(10) + 1;
	}
}
