package linkedQueue_Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import LinkedQueue.LinkedQueue;

public class Test_LinkedQueue {
	
	private LinkedQueue<Integer> queue;
	private final int MAX = 100;
	
	@Before
	public void antes(){
		 queue = new LinkedQueue<Integer>(); 
	}
	
	@Test
	public void testOffer() {
		for ( int i = 0; i < MAX; i++){
			queue.offer(i);
		}
		assertEquals(MAX, queue.size());
	}
	
	
	@Test
	public void testPeek() {
		testOffer();
		assertEquals(new Integer(0), queue.peek());
	}
	
	@Test
	public void testPoll() {
		testOffer();
		for ( Integer i = 0; i < MAX ; i++){
			assertEquals(i,queue.poll());
		}
		assertEquals(0, queue.size());
	}
	
	
	@Test
	public void testClear() {
		testOffer();
		assertEquals(MAX, queue.size());
		queue.clear();
		assertEquals(0, queue.size());
	}
	
	
	@Test
	public void testIterator() {
		testOffer();
		for (int i : queue){
			System.out.print(" "+i);
		}
	}

}
