package LinkedQueue;


import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The method remove in the iterator is not implemented.
 * 
 *  [] --> [] --> [] --> null
 *
 *
 * @param <T> generic element
 */
public class LinkedQueue<T> extends AbstractQueue<T>  
				implements java.io.Serializable{

    private static final long serialVersionUID = 54455451115548L;

    private int numElements;
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue(){
    	this.firstNode = null; this.lastNode = null; this.numElements = 0;
    }
	
	@Override
	public boolean offer(T e) {
		if (e == null)
            throw new NullPointerException();
		
		Node node = new Node(e,null);
		if ( size() == 0){
			firstNode = node;
		}
		else {
			lastNode.nextNode = node;
		}
		lastNode = node;
		numElements++;
		
		return true;
	}

	@Override
	public T poll() {
		if ( isEmpty() ){
			return null;
		}
		
		T element = firstNode.element;
		if ( size() == 1){
			firstNode = null;
			lastNode = null;
		}else{
			firstNode = firstNode.nextNode;
		}
		numElements--;
		return element;
	}

	@Override
	public T peek() {
		return firstNode.element;
	}

	@Override
	public int size() {
		return numElements;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	
	private class Node {
		private T element;
		private Node nextNode;
		
		private Node(T element, Node nextNode){
			this.element = element;
			this.nextNode = nextNode;
		}
	}
	
	private class QueueIterator implements Iterator<T>{

		private Node current;
		public QueueIterator(){
			this.current = firstNode;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if ( !hasNext() )
                throw new NoSuchElementException();
			T element = current.element;
			current = current.nextNode;
			return element;
		}
		
		@Override
		public void remove(){ 
        	throw new UnsupportedOperationException();  
        }
	}
}
