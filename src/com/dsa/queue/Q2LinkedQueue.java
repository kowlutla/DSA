/**
 * 
 */
package com.dsa.queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class Q2LinkedQueue<T> implements Queue<T> {
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			
			this.data = data;
			this.next = null;
			
		}
		
		public T getData() {
			
			return data;
			
		}
		
		public void setData(T data) {
			
			this.data = data;
			
		}
		
		public Node<T> getNext() {
			
			return next;
			
		}
		
		public void setNext(Node<T> next) {
			
			this.next = next;
			
		}
		
	}
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public Q2LinkedQueue() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
		
	}
	
	@Override
	public void add(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
		
	}
	
	@Override
	public T remove() {
		
		if (isEmpty()) {
			throw new RuntimeException("Queue Empty");
		}
		T data = head.getData();
		head = head.getNext();
		size--;
		return data;
		
	}
	
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("Queue Empty");
		}
		return head.getData();
		
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
		
		return false;
		
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		Node<T> current = head;
		String deli = "";
		
		while (current != null) {
			sb.append(deli).append(current.getData());
			current = current.getNext();
			deli = "->";
		}
		return sb.toString();
		
	}
	
}
