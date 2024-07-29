/**
 * 
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST2LinkedStack<T> implements Stack<T> {
	
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
	
	private Node<T> head;
	private int size;
	
	public ST2LinkedStack() {
		
		this.head = null;
		this.size = 0;
		
	}
	
	@Override
	public void push(T data) {
		
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
		size++;
		
	}
	
	@Override
	public T pop() {
		
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		T data = head.getData();
		size--;
		head = head.getNext();
		return data;
		
	}
	
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
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
