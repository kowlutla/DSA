/**
 * 	Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
	The first node is considered odd, and the second node is even, and so on.
	Note that the relative order inside both the even and odd groups should remain as it was in the input.
	You must solve the problem in O(1) extra space complexity and O(n) time complexity.
	
	Example 1:
	Input: head = [1,2,3,4,5]
	Output: [1,3,5,2,4]

	Example 2:
	Input: head = [2,1,3,5,6,4,7]
	Output: [2,3,6,7,1,5,4]
 
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L17OddEvenLinkedList {

	public Node oddEvenList(Node head) {
		Node even = new Node(-1); // Dummy node for the even list
		Node odd = new Node(-1); // Dummy node for the odd list

		Node lastEven = even;
		Node lastOdd = odd;

		Node current = head;
		int index = 1;

		// Traverse the original list and rearrange nodes in place
		while (current != null) {
			if (index % 2 == 0) { // if it is even index
				lastEven.next = current; // Attach to the even list
				lastEven = current;
			} else {
				lastOdd.next = current; // Attach to the odd list
				lastOdd = current;
			}
			index++;
			current = current.next;
		}

		lastEven.next = null; // End the even list
		lastOdd.next = even.next; // Link the end of odd list to the start of
									// even list
		head = odd.next; // Update head to the start of the odd list
		return head; // Return the head of the new list
	}
}
