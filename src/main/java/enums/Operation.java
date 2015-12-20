package enums;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
	PLUS("+") {
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	// Implementing a fromString method on an enum type
	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

	// Initialize map from constant name to enum constant
	static {
		for (Operation op : Operation.values()) {
			stringToEnum.put(op.toString(), op);
		}
	}

	abstract double apply(double x, double y);

	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	// Switch on an enum to simulate a missing method
	public static Operation inverse(Operation op) {
		switch (op) {
		case PLUS:
			return Operation.MINUS;
		case MINUS:
			return Operation.PLUS;
		case TIMES:
			return Operation.DIVIDE;
		case DIVIDE:
			return Operation.TIMES;
		default:
			throw new AssertionError("Unknown op: " + op);
		}
	}
}
