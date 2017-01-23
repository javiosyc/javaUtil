package mockitoExample;

public class ExcpetionClas {

    public ExcpetionClas() {

	if (2 == 1) {
	    throw new RuntimeException();
	}
    }

    public void test() {
	System.out.println("aa");
    }
}
