/**
 * 	Geek loves linked list data structure. Given an array of integer arr of size n, 
 	Geek wants to construct the linked list from arr.

	Construct the linked list from arr and return the head of the linked list.
	
	Example 1:
	Input:
	n = 5
	arr = [1,2,3,4,5]
	Output:
	1 2 3 4 5
	Explanation: Linked list for the given array will be 1->2->3->4->5.

	Example 2:
	Input:
	n = 2
	arr = [2,4]
	Output:
	2 4
	Explanation: Linked list for the given array will be 2->4.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L1ConstructLinkedList {

	/**
	 * Constructs a linked list from the given array of integers.
	 * 
	 * @param arr
	 *            The input array of integers.
	 * @return The head node of the constructed linked list.
	 */
	public static Node constructLL(int[] arr) {
		// Initialize a dummy head node
		Node head = new Node(0);
		Node current = head;

		// Iterate through each element in the array
		for (int n : arr) {
			// Create a new node for each element
			Node newNode = new Node(n);
			// Link the current node to the new node
			current.next = newNode;
			// Move the current pointer to the new node
			current = newNode;
		}
		// Return the next node of the dummy head, which is the actual head of
		// the linked list
		return head.next;
	}

	/**
	 * Prints the elements of the linked list.
	 * 
	 * @param head
	 *            The head node of the linked list.
	 */
	public static void printLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		// Construct the linked list from the array
		Node head = constructLL(arr);

		// Print the linked list
		System.out.println("Constructed Linked List:");
		printLinkedList(head);
	}
}
