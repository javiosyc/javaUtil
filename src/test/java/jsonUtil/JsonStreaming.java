package jsonUtil;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public class JsonStreaming {

	@Test
	public void test() throws JsonParseException, IOException {

		JsonFactory factory = new JsonFactory();

		JsonParser jp = factory.createParser(new File("test.json"));
	}
}
