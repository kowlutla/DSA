package com.dsa.queue;

import java.util.Arrays;

public class Q1ArrayQueue<T> implements Queue<T> {
	
	private T[] elements;
	private int front, rear;
	private int capacity;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Q1ArrayQueue() {
		
		this.capacity = 5;
		this.elements = (T[]) new Object[capacity];
		front = rear = size = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public Q1ArrayQueue(int capacity) {
		
		this.capacity = capacity;
		this.elements = (T[]) new Object[capacity];
		front = rear = size = 0;
		
	}
	
	@Override
	public void add(T data) {
		
		if (isFull()) {
			throw new RuntimeException("Queue is full");
		}
		elements[rear % capacity] = data;
		rear++;
		size++;
		
	}
	
	@Override
	public T remove() {
		
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		T data = elements[front % capacity];
		elements[front % capacity] = null;
		front++;
		size--;
		return data;
		
	}
	
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		return elements[front % capacity];
		
	}
	
	@Override
	public int size() {
		
		return size;
		
	}
	
	@Override
	public boolean isEmpty() {
		
		return size() == 0;
		
	}
	
	@Override
	public boolean isFull() {
		
		return size() == capacity;
		
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(elements);
		
	}
}