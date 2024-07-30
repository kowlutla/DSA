/**
 * 
 */
package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
/**
 * 
 * Implementing stack using queue by making pop operation as costly
 * 
 */
public class ST4StackUsingQueue2<T> implements StackCustom<T> {
	
	private Queue<T> original;
	private Queue<T> auxilary;
	
	public ST4StackUsingQueue2() {
		
		this.original = new LinkedList<>();
		this.auxilary = new LinkedList<>();
		
	}
	
	@Override
	public void push(T data) {
		
		original.add(data);
		
	}
	
	@Override
	public T pop() {
		
		if (isEmpty()) {
			throw new RuntimeException("StackCustom is Empty");
		}
		
		// Move all elements of original queue to aux except last element
		while (original.size() != 1) {
			auxilary.add(original.remove());
		}
		
		// remove the last element to return
		T data = original.remove();
		
		Queue<T> temp = auxilary;
		auxilary = original;
		original = temp;
		
		return data;
		
	}
	
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("StackCustom is Empty");
		}
		return original.remove();
		
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
