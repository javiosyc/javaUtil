package jsonUtil;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonSerializationAnnotationTest {

	/**
	 * The @JsonAnyGetter annotation allows the flexibility of using a Map field
	 * as standard properties.
	 * 
	 * Here’s a quick example – the ExtendableBean entity has the name property
	 * and a set of extendable attributes in form of key/value pairs:
	 * 
	 * @throws JsonProcessingException
	 */
	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
		ExtendableBean bean = new ExtendableBean("My bean");
		bean.add("attr1", "val1");
		bean.add("attr2", "val2");

		String result = new ObjectMapper().writeValueAsString(bean);
		assertThat(result, containsString("attr1"));
		assertThat(result, containsString("val1"));

		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
		MyBean bean = new MyBean(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		assertThat(result, containsString("My bean"));
		assertThat(result, containsString("1"));
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonPropertyOrder_thenCorrect() throws JsonProcessingException {
		MyBean bean = new MyBean(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		assertThat(result, containsString("My bean"));
		assertThat(result, containsString("1"));
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {

		RawBean bean = new RawBean("My bean", "{\"attr\":false}");

		String result = new ObjectMapper().writeValueAsString(bean);
		assertThat(result, containsString("My bean"));
		assertThat(result, containsString("{\"attr\":false}"));

		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {

		String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);

		assertThat(enumAsString, is("\"Type A\""));

		System.out.println(enumAsString);
	}

	@Test
	public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
		UserWithRoot user = new UserWithRoot(1, "John");

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String result = mapper.writeValueAsString(user);

		assertThat(result, containsString("John"));
		assertThat(result, containsString("user"));
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

		String toParse = "20-12-2014 02:30:00";
		Date date = df.parse(toParse);

		Event event = new Event("party", date);

		String result = new ObjectMapper().writeValueAsString(event);
		assertThat(result, containsString(toParse));
		System.out.println(result);
	}

}
