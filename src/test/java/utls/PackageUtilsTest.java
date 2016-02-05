package utls;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class PackageUtilsTest {

	@Test
	public void getClasses() throws IOException, ClassNotFoundException {

		Class<?>[] classes = PackageUtils.getClasses("bean");

		for (Class<?> clazz : classes) {
			System.out.println(clazz.getName());
		}

		assertThat(classes.length, equalTo(3));
	}

}
