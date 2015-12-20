package enums;

import org.junit.Test;

public class PayrollDayTest {

	@Test
	public void test() {
		System.out.println(PayrollDay.FRIDAY.pay(10, 2));
		System.out.println(PayrollDay.SATURDAY.pay(10, 2));
	}
}
