package mockitoExample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Tester {

    @Mock
    private ExcpetionClas exp = new ExcpetionClas();

    @Test
    public void atest() {

	Mockito.

	doNothing().when(exp).test();
    }
}
