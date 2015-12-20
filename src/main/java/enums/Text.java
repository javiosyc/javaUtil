package enums;

import java.util.Set;

public class Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {
		// ...
		for(Style style : styles) {
			System.out.println(style);
		}
	}
}
