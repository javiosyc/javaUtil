package jsonUtil;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean {

	public String name;
	private String attr1;
	private String attr2;
	private Map<String, String> properties;

	public ExtendableBean() {

	}

	public ExtendableBean(String name) {
		this.name = name;
	}

	public ExtendableBean(String name, String attr1, String attr2) {
		super();
		this.name = name;
		this.attr1 = attr1;
		this.attr2 = attr2;
	}

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}
}
