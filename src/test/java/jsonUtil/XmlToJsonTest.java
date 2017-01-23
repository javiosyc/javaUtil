package jsonUtil;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlToJsonTest {
	@Test
	public void test() throws IOException {
		String browsersAsJson = "[{\"name\":\"Chrome\"},{\"name\":\"FireFox\"},{\"name\":\"Internet Explorer\"}]\n";

		ObjectMapper jsonMapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		List<Browser> browsers = jsonMapper.readValue(browsersAsJson, List.class);

		JacksonXmlModule module = new JacksonXmlModule();

		
		XmlMapper xmlMapper = new XmlMapper(module);

		String browsersAsXml = xmlMapper.writeValueAsString(browsers);

		System.out.println(browsersAsXml);
	}
}
