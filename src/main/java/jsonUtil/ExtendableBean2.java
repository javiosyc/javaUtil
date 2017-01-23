package jsonUtil;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean2 {

	public String attr2;
	public String attr1;
	public String name;
	private Map<String, String> properties;

	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper("").append("attr1", attr1)
				.append("attr2", attr2).toString();

	}
}
