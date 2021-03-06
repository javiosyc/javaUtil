package jsonUtil;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
	TYPE1(1, "Type A"), TYPE2(2, "Type 2");

	private Integer id;
	private String name;

	private TypeEnumWithValue(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
