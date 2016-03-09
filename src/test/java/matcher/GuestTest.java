package matcher;

import static matcher.FirstOddItems.firstOddItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GuestTest {

	@Test
	public void testGenerate() {
		List<String> names = new ArrayList<String>();

		names.add("1");
		names.add("a");
		names.add("2");
		names.add("b");

		assertThat(names, firstOddItems("1","2"));
	}
}
