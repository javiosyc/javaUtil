package utls;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void test() {

		Date date = Calendar.getInstance().getTime();
		
		
		Date addDate =DateUtils.addWeeks(date, 1);
		
		System.out.println(addDate);
	}
}
