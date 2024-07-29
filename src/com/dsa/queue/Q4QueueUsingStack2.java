/**
 * 
 */
package com.dsa.queue;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
/**
 *  Implementing Queue using stack by making remove operation costly
 */
public class Q4QueueUsingStack2<T> implements Queue<T> {
	
	private Stack<T> original;
	private Stack<T> auxilary;
	
	public Q4QueueUsingStack2() {
		
		this.original = new Stack<>();
		this.auxilary = new Stack<>();
		
	}
	
	@Override
	public void add(T data) {
		
		original.add(data);
		
	}
	
	@Override
	public T remove() {
		
		if (original.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		
		// move all elements of original stack to aux
		while (original.size() != 1) {
			auxilary.push(original.pop());
		}
		
		// take the first element as data to remove
		T data = original.pop();
		
		// move all elements of aux stack to original
		while (!auxilary.isEmpty()) {
			original.push(auxilary.pop());
		}
		return data;
		
	}
	
	@Override
	public T peek() {
		
		if (original.isEmpty()) {
			throw new RuntimeException("Queue is empty");
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
