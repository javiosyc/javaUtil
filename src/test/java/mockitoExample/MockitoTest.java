package mockitoExample;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MockitoTest {

    private ArrayList<String> mockedList;

    @Before
    public void init() {
	mockedList = mock(ArrayList.class);
    }

    @Test
    public void verifyBehaviour() {

	mockedList.add("one");
	mockedList.clear();

	verify(mockedList).add("one");
	verify(mockedList).clear();
    }

    @Test
    public void stubbing() {
	@SuppressWarnings("unchecked")
	LinkedList<String> mockedList = mock(LinkedList.class);

	// stubbing
	when(mockedList.get(0)).thenReturn("fisrt");
	when(mockedList.get(1)).thenThrow(new RuntimeException());

	System.out.println(mockedList.get(0));

	System.out.println(mockedList.get(1));

	System.out.println(mockedList.get(99));

	// Although it is possible to verify a stubbed invocation, usually it's
	// just redundant
	// If your code cares what get(0) returns, then something else breaks
	// (often even before verify() gets executed).
	// If your code doesn't care what get(0) returns, then it should not be
	// stubbed. Not convinced? See here.
	verify(mockedList).get(0);
    }

    @Test
    public void argumnentMatchers() {

	when(mockedList.get(anyInt())).thenReturn("elment");

	// when(mockedList.contains(argThat(isValid()))).thenReturn(value);

	System.out.println(mockedList.get(999));

	verify(mockedList).get(anyInt());
    }

    // Verifying exact number of invocations / at least x / never
    @Test
    public void verifying() {

	mockedList.add("once");

	mockedList.add("twice");
	mockedList.add("twice");

	mockedList.add("three times");
	mockedList.add("three times");
	mockedList.add("three times");

	// following two verifications work exactly the same - times(1) is used
	// by default
	verify(mockedList).add("once");
	verify(mockedList, times(1)).add("once");

	// exact number of invocations verification

	verify(mockedList, times(2)).add("twice");
	verify(mockedList, times(3)).add("three times");

	verify(mockedList, never()).add("never happened");

	verify(mockedList, atLeastOnce()).add("three times");

	verify(mockedList, atLeast(2)).add("three times");

	verify(mockedList, atMost(5)).add("three times");

    }

    // 5. Stubbing void methods with exceptions
    @Test
    public void stubingWithException() {

	doThrow(new RuntimeException()).when(mockedList).clear();

	mockedList.clear();
    }

    // 6. Verification in order
    public void verificationInOrder() {
	List<String> singleMock = mock(List.class);

	singleMock.add("was added first");
	singleMock.add("was added second");

	InOrder inOrder = inOrder(singleMock);

	inOrder.verify(singleMock).add("was added first");
	inOrder.verify(singleMock).add("was added second");

	List<String> firstMock = mock(List.class);
	List<String> secondMock = mock(List.class);

	firstMock.add("was added first");
	secondMock.add("was added second");

	InOrder inOrder2 = inOrder(firstMock, secondMock);

	inOrder2.verify(firstMock).add("was added first");
	inOrder2.verify(secondMock).add("was added second");
    }

    // Making sure interactoins never happen on mock
    @Test
    public void interactions() {
	List<String> mockOne = mock(List.class);
	List<String> mockTwo = mock(List.class);
	List<String> mockThree = mock(List.class);

	mockOne.add("one");

	verify(mockOne).add("one");

	verify(mockOne, never()).add("two");

	verifyZeroInteractions(mockOne, mockThree);
    }

    @Test
    public void findingRedundantInvocations() {
	mockedList.add("one");
	mockedList.add("two");

	verify(mockedList).add("one");
	verify(mockedList).add("two");

	verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void stubbingConsecutiveCalls() {

	when(mockedList.add("1")).thenThrow(new RuntimeException()).thenReturn(true);

	try {
	    mockedList.add("1");
	} catch (Exception e) {
	    System.out.println(e);
	}

	System.out.println(mockedList.add("1"));
	System.out.println(mockedList.add("1"));

	when(mockedList.add("1")).thenReturn(true, false, true);

	System.out.println("-----");
	System.out.println(mockedList.add("1"));
	System.out.println(mockedList.add("1"));
	System.out.println(mockedList.add("1"));
    }

    @Test
    public void stubbingWithCallBacks() {

	when(mockedList.add(anyString())).thenAnswer(new Answer<Object>() {

	    @Override
	    public Object answer(InvocationOnMock invocation) throws Throwable {
		Object[] args = invocation.getArguments();

		for (Object arg : args) {
		    System.out.println(arg.getClass().getName());
		}

		System.out.println(invocation.getMethod().getReturnType().getName());

		return false;
	    }
	});

	System.out.println(mockedList.add("123"));
    }

    @Test
    public void familyOfMethods() {

	doThrow(new RuntimeException()).when(mockedList).clear();

	mockedList.clear();
    }

    @Test
    public void spyingOnRealObjecct() {
	List<String> list = new LinkedList<String>();
	List<String> spy = spy(list);

	// optionally, you can stub out some methods;

	when(spy.size()).thenReturn(100);

	spy.add("one");
	spy.add("two");

	System.out.println(spy.get(0));

	System.out.println(spy.size());

	System.out.println(spy.get(1));

	verify(spy).add("one");
	verify(spy).add("two");

	List<String> list2 = new LinkedList<String>();
	List<String> spy2 = spy(list2);

	// Impossible: real method is called so spy.get(0) throws
	// IndexOutOfBoundsException (the list is yet empty)
	// when(spy2.get(0)).thenReturn("foo");

	// You have to use doReturn() for stubbing
	doReturn("foo").when(spy2).get(0);
    }

    @Test
    public void changingDefalutReturnValues() {
	List list = mock(ArrayList.class, Mockito.RETURNS_SMART_NULLS);

    }

    @Test
    public void capturingArgumnet() {
	List<String> list = mock(ArrayList.class);
	ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

	when(list.contains(captor.capture())).thenReturn(false);

	System.out.println(list.contains("123"));
	System.out.println(list.contains("4567x"));

	for (String test : captor.getAllValues()) {
	    System.out.println(test);
	}
	System.out.println(captor.getValue());
    }
}
