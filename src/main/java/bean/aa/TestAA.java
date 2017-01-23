package bean.aa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person", namespace = "test")
public class TestAA {

	@XmlAttribute
	private String a;
	private String e;
	private String c;
	private String d;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

}
