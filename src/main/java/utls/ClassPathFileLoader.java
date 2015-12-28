package utls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ClassPathFileLoader {

	private static URL getPathFromClasspathResource(String path) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(path);

		if (url == null) {
			throw new RuntimeException(url + " is not found.");
		}
		return url;
	}

	private static FileInputStream getFileClasspathResource(String path)
			throws FileNotFoundException, URISyntaxException {

		return new FileInputStream(new File(getPathFromClasspathResource(path).toURI()));
	}

	public static String getContent(URL url, String encoding) {
		try {
			return IOUtils.toString(url, encoding);
		} catch (IOException e) {
			throw new RuntimeException("read the file (" + url + " ) is failed.");
		}
	}

	public static String getContent(String path) {
		return getContent(getPathFromClasspathResource(path), "utf-8");
	}

	public static byte[] getImage(String path) {
		try {
			return IOUtils.toByteArray(getFileClasspathResource(path));
		} catch (FileNotFoundException | URISyntaxException e) {
			throw new RuntimeException(path + " is not found.");
		} catch (IOException e) {
			throw new RuntimeException("read the file (" + path + " ) is failed.");
		}
	}
}
