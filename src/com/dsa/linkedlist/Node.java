package com.dsa.linkedlist;

public class Node {

	int data;
	Node next;
	Node prev; // to use for doubly linkedlist

	public Node() {
		data = 0;
	}

	
	public Node(int d) {
		data = d;
	}
}