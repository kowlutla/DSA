package com.dsa.stack;

import java.util.Arrays;

public class ST1ArrayStack<T> {
	
	private int size;
	private T[] elements;
	
	@SuppressWarnings("unchecked")
	public ST1ArrayStack() {
		
		elements = (T[]) new Object[3];
		size = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public ST1ArrayStack(int initialCapacity) {
		
		elements = (T[]) new Object[initialCapacity];
		size = 0;
		
	}
	
	public void push(T data) {
		
		if (isFull()) {
			System.out.println("Stack is full");
			grow();
		}
		elements[size] = data;
		size++;
		
	}
	
	private void grow() {
		
		System.out.println("Grow called...");
		elements = Arrays.copyOf(elements, elements.length * 2);
		
	}
	
	public T pop() {
		
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		T data = elements[size - 1];
		elements[size - 1] = null;
		size--;
		
		if (size > 0 && size == elements.length / 4) {
			shrink();
		}
		return data;
		
	}
	
	private void shrink() {
		
		elements = Arrays.copyOf(elements, elements.length / 2);
		
	}
	
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return elements[size - 1];
		
	}
	
	public int size() {
		
		return size;
		
	}
	
	public boolean isEmpty() {
		
		return size == 0;
		
	}
	
	public boolean isFull() {
		
		return size == elements.length;
		
	}
	
	public String toString() {
		
		return Arrays.toString(elements);
		
	}
}