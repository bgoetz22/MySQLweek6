
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	private TestDemo testDemoB;

	/**
	 * reference: https://github.com/DrOldGuy/cohort_915_mysql-week-6.git
	 */
	
	@BeforeEach
	void setup() {
		testDemoB = new TestDemo(); // testDemoB is the mocking class named 'testDemoB' used it to show that is was
									// an object not static class.
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemoB.addPositive(a, b)).isEqualTo(expected);
		} else
			assertThatThrownBy(() -> testDemoB.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false), arguments(-2, 4, 0, true), arguments(2, -4, 0, true));

	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemoB);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
