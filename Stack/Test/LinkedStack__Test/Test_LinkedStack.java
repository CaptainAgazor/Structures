package LinkedStack__Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import LinkedStack.Stack;

public class Test_LinkedStack {
	
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
	
	
}
