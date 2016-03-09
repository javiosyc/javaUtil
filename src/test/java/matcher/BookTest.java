package matcher;

import static matcher.BookMatcher.hasIsbn;
import static matcher.LessThanOrEqual.lessThanOrEqual;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBookIsbn() {
		Book book = new Book(11, "555", "test");

		assertThat(book, hasIsbn("123"));
	}

	@Test
	public void lessthanOrEquals_matcher() {
		int actualGoalScored = 2;
		int expGoalScored = 4;

		assertThat(actualGoalScored, lessThanOrEqual(expGoalScored));

		double actualDouble = 3.14;
		double expDouble = 9.00;

		assertThat(actualDouble, lessThanOrEqual(expDouble));

		String authorName = "Sujoy";
		String expAuthName = "Zachary";

		assertThat(authorName, lessThanOrEqual(expAuthName));
	}

	@Test
	public void lessthanOrEquals_matcher_error() {
		long maxInt = Long.MAX_VALUE;
		assertThat(maxInt, lessThanOrEqual(Long.MIN_VALUE));
	}
}
