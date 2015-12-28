package utls;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.junit.Test;

public class ClassPathFileLoaderTest {

	@Test
	public void loadFileFromClassPath() throws IOException {
	
		String context = ClassPathFileLoader.getContent("test.txt");
		assertThat (context , equalTo("text"));
	}

	@Test
	public void getImage() throws IOException, SerialException, SQLException {
		byte[] context = ClassPathFileLoader.getImage("images.jpeg");
		System.out.println(context.length);
	}
}
