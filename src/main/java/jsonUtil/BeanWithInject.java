package jsonUtil;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {
	@JacksonInject
	public int id;

	public String name;

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper("").append("id", id)
				.append("name", name).toString();

	}
}
