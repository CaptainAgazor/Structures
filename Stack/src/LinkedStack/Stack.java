package LinkedStack;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Stack <T> implements Iterable<T>{

	private Node currentNode;
	private int numElements;
	
	public Stack(){
		this.currentNode = null;
		this.numElements = 0;
	}
	
	public int size(){
		return this.numElements;
	}
	
	public boolean isEmpty(){
		return this.currentNode == null;
	}
	
	public T push(T element){
		
		currentNode = new Node(element,currentNode);
		numElements++;
		return element;
	}
	
	public T pop(){
        if (isEmpty()) 
        	throw new NoSuchElementException("There are not elements in the stacl to delete");
        
        T element = currentNode.element;
        currentNode = currentNode.previous;
        numElements--;
        
        return element;
	}
	
	public T peek(){
		return currentNode.element;
	}
	
	public void clear(){
		while ( ! isEmpty()){
			pop();
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new stackIterator();
	}
	
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");
        return s.toString();
    }
	
	private class Node{
		
		private T element;
		private Node previous;
		
		private Node(T element,Node previous){
			this.element = element;
			this.previous = previous;
		}
	}
	
	private class stackIterator implements Iterator<T>{

		private Node current;
		private stackIterator(){
			this.current = currentNode;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (currentNode == null)
                throw new NoSuchElementException();
			T element = current.element;
			current = current.previous;
			return element;
		}
		
		@Override
        public void remove(){ 
        	throw new UnsupportedOperationException();  
        }
		
	}
}
