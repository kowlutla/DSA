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
 * Implementing Queue using stack by making remove operation costly(Optimized)
 */
public class Q5QueueUsingStack3<T> implements Queue<T> {
	
	private Stack<T> original;
	private Stack<T> auxilary;
	
	public Q5QueueUsingStack3() {
		
		this.original = new Stack<>();
		this.auxilary = new Stack<>();
		
	}
	
	@Override
	public void add(T data) {
		
		original.add(data);
		
	}
	
	@Override
	public T remove() {
		
		if (original.isEmpty() && auxilary.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		
		if (!auxilary.isEmpty()) {
			return auxilary.pop();
		} else {
			
			while (!original.isEmpty()) {
				auxilary.push(original.pop());
			}
			return auxilary.pop();
		}
		
	}
	
	@Override
	public T peek() {
		
		if (original.isEmpty() && auxilary.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		
//		return original.peek();
		if (!auxilary.isEmpty()) {
			return auxilary.peek();
		} else {
			return original.peek();
		}
		
	}
	
	@Override
	public int size() {
		
		return original.size();
		
	}
	
	@Override
	public boolean isEmpty() {
		
		return original.isEmpty() && auxilary.isEmpty();
		
	}
	
	@Override
	public boolean isFull() {
		
		return false;
		
	}
	
	public String toString() {
		
		return String.valueOf(original);
		
	}
	
}
