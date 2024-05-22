/**
 * 	Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop. If a loop is present return the node data of the first node of the loop else return -1.
	
	Example 1:
	Input: 1 -> 3 -> 2 -> 4 -> 5 -> 3
	Output: 3
	Explanation:
	We can see that there exists a loop 
	in the given linked list and the first
	node of the loop is 3.
	 
	
	Example 2:
	Input: 1 -> 2 -> 3-> 4
	Output: -1
	Explanation: No loop exists in the above
	linked list.So the output is -1.
 */
package com.dsa.linkedlist;

import java.util.HashSet;

/**
 * @author KowlutlaSwamy
 *
 */
public class L14FirstNodeInLoop {

	/**
	 * Finds the first node in the loop using a HashSet.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the list. Space
	 * Complexity: O(N), for storing nodes in the HashSet.
	 *
	 * @param head
	 *            The head node of the linked list.
	 * @return The data of the first node in the loop, or -1 if no loop is
	 *         found.
	 */
	public static int findFirstNode1(Node head) {
		// Create a HashSet to store visited nodes
		HashSet<Node> set = new HashSet<>();
		Node current = head;

		// Traverse the list
		while (current != null) {
			// If the current node is already in the set, the loop is detected
			if (!set.add(current))
				return current.data;
			current = current.next;
		}

		return -1; // No loop detected
	}

	/**
	 * Finds the first node in the loop using Floyd’s Cycle-Finding Algorithm.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the list. Space
	 * Complexity: O(1), as no additional space is used.
	 *
	 * @param head
	 *            The head node of the linked list.
	 * @return The data of the first node in the loop, or -1 if no loop is
	 *         found.
	 */
	public static int findFirstNode2(Node head) {

		if (head == null || head.next == null)
			return -1;
		Node slow = head;
		Node fast = head;

		// Traverse the list with two pointers
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast pointers meet, a loop is detected
			if (slow == fast) {
				break;
			}
		}

		// If fast reached the end, no loop is present
		if (fast == null || fast.next == null) {
			return -1;
		}

		// Move one pointer to the start and traverse again to find the first
		// node in the loop
		Node current = head;
		while (current != slow) {
			current = current.next;
			slow = slow.next;
		}

		return current.data; // First node in the loop
	}
}
