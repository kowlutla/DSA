/**
 * 
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public interface Stack<T> {
	
	public void push(T data);
	
	public T pop();
	
	public T peek();
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
