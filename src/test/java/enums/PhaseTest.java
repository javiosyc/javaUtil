package enums;

import org.junit.Test;

public class PhaseTest {

	@Test
	public void transitionFrom() {
		System.out.println(Phase.Transition.from(Phase.LIQUID, Phase.GAS));
		System.out.println(Phase.Transition.from(Phase.GAS, Phase.SOLID));
	}
}
