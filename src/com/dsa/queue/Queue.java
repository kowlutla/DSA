/**
 * 
 */
package com.dsa.queue;

/**
 * @author KowlutlaSwamy
 *
 */
public interface Queue<T> {
	
	public void add(T data);
	
	public T remove();
	
	public T peek();
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
