package enums;

import java.util.EnumSet;

import org.junit.Test;

import enums.Text.Style;

public class TextTest {

	@Test
	public void test() {
		Text text = new Text(); 
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
