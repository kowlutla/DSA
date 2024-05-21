/**
 * 	Given a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.
	
	Example 1:
	
	Input:
	LinkedList: 1->2->3->4->5
	Output: 5
	Explanation: Count of nodes in the 
	linked list is 5, which is its length.
	Example 2:
	
	Input:
	LinkedList: 2->4->6->7->5->1->0
	Output: 7
	Explanation: Count of nodes in the
	linked list is 7. Hence, the output
	is 7.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L4LengthOfLinkedList {

	/**
	 * Method to count the number of nodes in the linked list
	 * 
	 * @param head
	 *            The head node of the linked list
	 * @return The length of the linked list
	 */
	public static int getCount(Node head) {
		int len = 0;
		Node current = head;
		// Traverse the linked list and count the nodes
		while (current != null) {
			current = current.next;
			len++;
		}
		return len;
	}
}
