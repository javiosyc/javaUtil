package utls;

import org.junit.Test;

public class SwitchTest {

    @Test
    public void test() {

	String a = "1";

	switch (a) {
	case "1":
	    System.out.println("1");
	    break;
	case "2":
	    System.out.println("2");
	    break;
	default:
	    break;
	}
    }
}
