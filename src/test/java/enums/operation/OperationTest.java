package enums.operation;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class OperationTest {

	@Test
	public void apply() {
		double x = Double.parseDouble("2");
		double y = Double.parseDouble("3");
		test(ExtendedOperation.class, x, y);
	}
	
	@Test
	public void apply2() {
		double x = Double.parseDouble("2");
		double y = Double.parseDouble("3");
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}

	private <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	private void test(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
