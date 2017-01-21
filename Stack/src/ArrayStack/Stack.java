package ArrayStack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Serializable,Iterable<T>{

	static final long serialVersionUID = 1;
	static final double REDUCE_AVERAGE = 0.5;
	static final double REDUCE = 0.25;
	static final double MINREDUCE = 10;

	private Object[] elementData = null;
	private int initialSize = 10;
	private double increment;
	private int currentIndex;
	
	
	public Stack(){
		this.elementData = new Object[initialSize];
		this.increment = 0.75;
		this.currentIndex = 0;
	}
	
	/**
	 * 
	 * @param initialSize
	 * @param increment >= 0.5
	 */
	public Stack(int initialSize, double increment){
		this.elementData = new Object[initialSize];
		this.increment = increment;
		this.currentIndex = 0;
	}

	public double getIncrement(){
		return increment;
	}
	
	public synchronized int size(){
		return currentIndex;
	}
	
	public synchronized boolean isEmpty(){
		return size() == 0;
	}
	
	private boolean isFull(){
		return currentIndex == elementData.length;
	}
	
	private void grow(){
		int oldCapacity = elementData.length;
        int newCapacity = (int) ((int) oldCapacity * (1 + getIncrement()));
        System.out.println("Grow: Set new capacity "+newCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
  
	}
	
	private void shrink(){
		int oldCapacity = elementData.length;
        int newCapacity = (int) ((int) oldCapacity * (1 - REDUCE));
        System.out.println("Reduce"+currentIndex+": Set new capacity "+newCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
  
	}
	
	public synchronized void clear(){
		while(!isEmpty()){
			pop();
		}
	}
	
	public synchronized T push(T element){
		// grow
		if (isFull()){
			grow();
		}
		
		elementData[currentIndex++] = element;
		return element;
	}
	
    @SuppressWarnings("unchecked")
	public synchronized T pop(){
		if ( isEmpty()){
			throw new NoSuchElementException("There are not elements in the stacl to delete");
		}
		T element = (T) elementData[--currentIndex];
		elementData[currentIndex] = null;
		
		double fullCells = size()/(float)elementData.length;
		
		if ( currentIndex > MINREDUCE && fullCells < REDUCE_AVERAGE){
			System.out.printf("fullCells =%f\tsize()=%d\tvector=%d\n",fullCells,size(),elementData.length);
			shrink();
		}
		
		return element;
	}
    
    @SuppressWarnings("unchecked")
    public synchronized T peek(){
    	if ( isEmpty())
            throw new EmptyStackException();
    	return (T)elementData[currentIndex-1];
    }
    
    @Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
    
    private class StackIterator implements Iterator<T>{

    	private int current;
    	
    	public StackIterator(){
    		this.current = currentIndex;
    	}
		@Override
		public boolean hasNext() {
			return current > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public synchronized T next() {
			if (current <= 0)
                throw new NoSuchElementException();
			return (T) elementData[--current];
		}
    	
		@Override
		public void remove(){ 
        	throw new UnsupportedOperationException();  
        }
    }
}
