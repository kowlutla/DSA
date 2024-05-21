package com.dsa.linkedlist;

public class Node {

	int data;
	Node next;
	Node prev; //to use for doubly linkedlist

	Node() {
		data = 0;
	}
	Node(int d) {
		data = d;
	}
}