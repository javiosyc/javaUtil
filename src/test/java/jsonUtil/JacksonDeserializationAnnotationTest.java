package jsonUtil;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeserializationAnnotationTest {

	@Test
	public void whenDeserializingUsingJsonCreator_thenCorrect() throws JsonProcessingException, IOException {
		String json = "{\"id\":1,\"theName\":\"My bean\"}";

		BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
		assertEquals("My bean", bean.name);
		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonInject_thenCorrect() throws JsonProcessingException, IOException {
		String json = "{\"name\":\"My bean\"}";

		InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);

		BeanWithInject bean = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);
		assertEquals("My bean", bean.name);
		assertEquals(1, bean.id);
		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonAnySetter_thenCorrect() throws JsonProcessingException, IOException {
		String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

		ExtendableBean2 bean = new ObjectMapper().readerFor(ExtendableBean2.class).readValue(json);

		assertEquals("My bean", bean.name);
		// assertEquals("val2", bean.getProperties().get("attr2"));

		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonSetter_thenCorrect() throws JsonProcessingException, IOException {
		String json = "{\"id\":1,\"name\":\"My bean\"}";

		MyBean bean = new ObjectMapper().readerFor(MyBean.class).readValue(json);
		assertEquals("My bean", bean.getTheName());
		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonDeserialize_thenCorrect()
	  throws JsonProcessingException, IOException {
	    String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
	 
	    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	    Event event = new ObjectMapper().readerFor(Event.class).readValue(json);
	     
	    assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
	}

}
