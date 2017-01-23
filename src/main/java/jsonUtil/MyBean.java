package jsonUtil;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({ "name", "id" })
public class MyBean {
	public int id;
	private String name;

	public MyBean() {

	}

	public MyBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonGetter("name")
	public String getTheName() {
		return name;
	}

	@JsonSetter("name")
	public void setTheName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper("").append("id", id)
				.append("name", name).toString();

	}
}