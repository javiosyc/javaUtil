package utls;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class BeanUtilsTest {

	@Test
	public void testProperties() throws ClassNotFoundException, IOException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?>[] classes = PackageUtils.getClasses("bean");

		for (Class<?> clazz : classes) {
			BeanUtils.testProperties(clazz);
		}
	}
}
