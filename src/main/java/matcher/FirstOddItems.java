package matcher;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class FirstOddItems<I> extends BaseMatcher<I> {

	private I items;

	public FirstOddItems(I items) {
		this.items = items;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("前奇數個不符");
	}

	@Override
	public boolean matches(Object object) {
		List result = (List) object;
		int i = 0;

		for (Object item : (List) items) {
			if (!item.equals(result.get(i))) {
				return false;
			}

			i += 2;
		}

		return true;
	}

	@Factory
	public static <T> Matcher<List<T>> firstOddItems(T... items) {
		return new FirstOddItems<List<T>>(Arrays.asList(items));
	}
}
