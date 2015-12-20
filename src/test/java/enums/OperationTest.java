package enums;

import org.junit.Test;

public class OperationTest {

	@Test
	public void apply() {
		double x = Double.parseDouble("23");
		double y = Double.parseDouble("33");
		for (Operation op : Operation.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	@Test
	public void inverse() {
		System.out.println(Operation.inverse(Operation.MINUS));
	}
}
