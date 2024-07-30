/**
 * 
 */
package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Implementing stack using queue by making push operation as costly
 * 
 */
public class ST3StackUsingQueue1<T> implements StackCustom<T> {
	
	private Queue<T> original;
	private Queue<T> auxiliary;
	
	public ST3StackUsingQueue1() {
		
		original = new LinkedList<T>();
		auxiliary = new LinkedList<T>();
		
	}
	
	@Override
	public void push(T data) {
		
		// Move all elements of original queue to other queue
		while (!original.isEmpty()) {
			auxiliary.add(original.remove());
		}
		
		// add the current element at the first of original queue
		original.add(data);
		
		// move all elements of aux queue to original queue
		while (!auxiliary.isEmpty()) {
			original.add(auxiliary.remove());
		}
		
	}
	
	@Override
	public T pop() {
		
		if (isEmpty()) {
			throw new RuntimeException("StackCustom is Empty");
		}
		return original.remove();
		
	}
	
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("StackCustom is Empty");
		}
		return original.peek();
		
	}
	
	@Override
	public int size() {
		
		return original.size();
		
	}
	
	@Override
	public boolean isEmpty() {
		
		return original.isEmpty();
		
	}
	
	@Override
	public boolean isFull() {
		
		return false;
		
	}
	
	public String toString() {
		
		return String.valueOf(original);
		
	}
}
