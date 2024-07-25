/**
 * 
 */
package com.dsa.queue;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class Q1QueueUsingArray {
	
	static class QueueImpl<T> {
		
		private T[] elements;
		private int front, rear;
		private int capacity;
		private int size;
		
		@SuppressWarnings("unchecked")
		public QueueImpl() {
			
			this.capacity = 5;
			this.elements = (T[]) new Object[capacity];
			front = rear = size = 0;
			
		}
		
		@SuppressWarnings("unchecked")
		public QueueImpl(int capacity) {
			
			this.capacity = capacity;
			this.elements = (T[]) new Object[capacity];
			front = rear = size = 0;
			
		}
		
		public void add(T data) {
			
			if (isFull()) {
				throw new RuntimeException("Queue is full");
			}
			elements[rear % capacity] = data;
			rear++;
			size++;
			
		}
		
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
		
		public T peek() {
			
			if (isEmpty()) {
				throw new RuntimeException("Queue is Empty");
			}
			return elements[front % capacity];
			
		}
		
		public int size() {
			
			return size;
			
		}
		
		public boolean isEmpty() {
			
			return size() == 0;
			
		}
		
		public boolean isFull() {
			
			return size() == capacity;
			
		}
		
		public String toString() {
			
			return Arrays.toString(elements);
			
		}
	}
	
	public static void main(String[] args) {
		
		QueueImpl<Integer> q = new QueueImpl<Integer>();
		q.add(10);
		System.out.println(q);
		q.add(11);
		q.add(12);
//	q.add(13);
		q.add(14);
//		System.out.println(q.peek());
//		System.out.println("Removed: "+q.remove());
//		System.out.println(q.peek());
//		q.add(12);
//		q.add(13);
//		q.add(14);
//		System.out.println(q);
//		q.remove();
//		q.remove();
//		q.remove();
//		q.remove();
//		System.out.println(q.size());
//		q.remove();
//		System.out.println(q);
//		System.out.println(q.peek());
		
		System.out.println("Size Of Queue: " + q.size());
		System.out.println("Queue Elements: ");
		
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		
	}
}

//[null, null, null, null, null] capacity = 5;
//add(10) => [10, null, null, null, null] front = 0, rear = 0, size = 1;
//add(11) => [10, 11, null, null, null] front = 0, rear = 1, size = 2;
//add(12) => [10, 11, 12, null, null] front = 0, rear = 2, size = 3;
//add(13) => [10, 11, 12, 13, null] front = 0, rear = 3, size = 4;
//add(14) => [10, 11, 12, 13, 14] front = 0, rear = 4, size = 5; => rear = 5
//remove() => 
//add(15) => [15, 11, 12, 13, 14] front = 1, rear = 5, size = 5;
//remove() = > [15, null, 12, 13, 14] front = 2, rear = 6, size = 4
//remove() => [15, null, null, 13, 14] front = 3, rear = 6, size = 3
//remove() =>  [15, null, null, null, 14] front = 4, rear = 6, size = 2
//remove() =>  [15, null, null, null, null] front = 5, rear = 6, size = 1