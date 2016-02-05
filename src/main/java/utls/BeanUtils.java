package utls;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtils {

	public static void testProperties(Class<?> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(clazz);

		if (Modifier.isAbstract(clazz.getModifiers())) {
			return;
		}

		for (PropertyDescriptor property : properties) {
			java.lang.reflect.Method getter = property.getReadMethod();
			java.lang.reflect.Method writter = property.getWriteMethod();

			Object object = clazz.newInstance();

			if (getter == null) {
				continue;
			}

			if (writter == null) {
				continue;
			}

			Type[] types = writter.getGenericParameterTypes();

			Object[] param = new Object[types.length];

			for (int i = 0; i < param.length; i++) {
				if (types[i] == boolean.class) {
					param[i] = false;
				}

				if (types[i] == String.class) {
					param[i] = "";
				}
				if (types[i] == float.class || types[i] == long.class || types[i] == int.class) {
					param[i] = 0;
				}
			}
			writter.invoke(object, param);
			System.out.println(getter.invoke(object));
		}
		clazz.toString();
	}

}
