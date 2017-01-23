package jsonUtil;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.aa.TestAA;

public class ObjectToJsonTest {

	@Test
	public void objectToJson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.setSerializationInclusion(Include.NON_NULL);

		TestAA aa = new TestAA();
		aa.setA("aa");

		System.out.println(objectMapper.writeValueAsString(aa));
	}
}
