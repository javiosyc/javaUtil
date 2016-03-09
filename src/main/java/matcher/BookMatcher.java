package matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BookMatcher {
	public static Matcher<Book> hasIsbn(final String isbn) {
		return new TypeSafeMatcher<Book>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Book isbn ").appendValue(isbn);
			}

			@Override
			protected boolean matchesSafely(Book book) {
				return isbn.equals(book.getIsbn());
			}

			@Override
			protected void describeMismatchSafely(Book book, Description mismatchDescription) {
				mismatchDescription.appendText("was ").appendText(book.getIsbn());
			}
		};
	}
}
