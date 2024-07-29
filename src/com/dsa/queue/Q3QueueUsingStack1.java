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
 *  Implementing Queue using stack by making add operation costly
 */
public class Q3QueueUsingStack1<T> implements Queue<T> {
	
	private Stack<T> original;
	private Stack<T> auxilary;
	
	public Q3QueueUsingStack1() {
		
		original = new Stack<T>();
		auxilary = new Stack<T>();
		
	}
	
	@Override
	public void add(T data) {
		
		// move all elements of original stack to aux stack
		while (!original.isEmpty()) {
			auxilary.add(original.pop());
		}
		
		// add current element to original stack
		original.push(data);
		
		// move all elements of aux stack to original stack
		
		while (!auxilary.isEmpty()) {
			original.push(auxilary.pop());
		}
		
	}
	
	@Override
	public T remove() {
		
		if (original.isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		return original.pop();
		
	}
	
	@Override
	public T peek() {
		
		if (original.isEmpty()) {
			throw new RuntimeException("Queue is Empty");
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
