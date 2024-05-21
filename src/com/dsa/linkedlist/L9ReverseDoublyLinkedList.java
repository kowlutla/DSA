/**
 * 	Given a doubly linked list of n elements. Your task is to reverse the doubly linked list in-place.
	
	Example 1:
	Input:
	LinkedList: 3 <--> 4 <--> 5
	Output: 5 4 3

	Example 2:
	Input:
	LinkedList: 75 <--> 122 <--> 59 <--> 196
	Output: 196 59 122 75
 */
package com.dsa.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author KowlutlaSwamy
 *
 */
public class L9ReverseDoublyLinkedList {

    /**
     * Reverses a doubly linked list using a stack.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), due to the stack used to store node data.
     *
     * @param head The head node of the doubly linked list.
     * @return The head node of the reversed doubly linked list.
     */
    public static Node reverseDLL1(Node head) {
        Deque<Integer> stack = new ArrayDeque<>(); // Initialize a stack to hold node data
        Node current = head;

        // Traverse the list and push all node data onto the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head; // Reset current to head

        // Traverse the list again and replace node data with values popped from the stack
        while (current != null) {
            current.data = stack.pop();
            current = current.next;
        }

        return head; // Return the head of the reversed list
    }

    /**
     * Reverses a doubly linked list by changing the pointers.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as it only uses a constant amount of extra space.
     *
     * @param head The head node of the doubly linked list.
     * @return The head node of the reversed doubly linked list.
     */
    public static Node reverseDLL2(Node head) {
        Node current = head;
        Node previousNode = null; // Initialize previousNode to null

        // Traverse the list and swap the next and prev pointers for each node
        while (current != null) {
            previousNode = current.prev; // Store the previous pointer
            current.prev = current.next; // Swap the next and prev pointers
            current.next = previousNode; // Move the current's next to previousNode
            current = current.prev; // Move to the next node in the original list
        }

        // After the loop, previousNode points to the original head
        if (previousNode != null) {
            head = previousNode.prev; // Move head to the new first node
        }

        return head; // Return the head of the reversed list
    }
}
