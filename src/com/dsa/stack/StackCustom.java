/**
 * 
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public interface StackCustom<T> {
	
	public void push(T data);
	
	public T pop();
	
	public T peek();
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
