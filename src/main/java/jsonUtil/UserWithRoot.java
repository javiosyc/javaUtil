package jsonUtil;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class UserWithRoot {
	public UserWithRoot(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int id;
	public String name;
}