package ArrayStack_Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ArrayStack.Stack;

public class Test_ArrayStack {
	
	private Stack<Integer> stack;
	private final int MAX = 100;
	
	@Before
	public void antes(){
		 stack = new Stack<Integer>(); 
	}
	
	@Test
	public void testAdd() {
		for ( int i = 0; i < MAX; i++){
			stack.push(i);
		}
		assertEquals(MAX, stack.size());
	}
	
	
	@Test
	public void testPeek() {
		testAdd();
		assertEquals(new Integer(MAX-1), stack.peek());
	}
	
	@Test
	public void testRemove() {
		testAdd();
		for ( Integer i = MAX -1; i >= 0; i--){
			assertEquals(i,stack.pop());
		}
		assertEquals(0, stack.size());
	}
	
	
	@Test
	public void testClear() {
		testAdd();
		assertEquals(MAX, stack.size());
		stack.clear();
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testAddClear() {
		int a, b;
		int evenNumber = 100;
		for ( int i = 0; i < evenNumber; i++){
			a = stack.push(i);
			if ( i % 2 == 0 ){
				b = stack.pop();
				assertEquals(a, b);
			}
		}
		assertEquals(evenNumber/2, stack.size());
	}
	
	@Test
	public void testIterator() {
		testAdd();
		for (int i : stack){
			System.out.print(" "+i);
		}
	}

}
