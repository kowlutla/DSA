/**
 * 	Given a linked list of N nodes. The task is to reverse this list.
	
	Example 1:
	Input:
	LinkedList: 1->2->3->4->5->6
	Output: 6 5 4 3 2 1
	Explanation: After reversing the list, 
	elements are 6->5->4->3->2->1.

	Example 2:
	Input:
	LinkedList: 2->7->8->9->10
	Output: 10 9 8 7 2
	Explanation: After reversing the list,
	elements are 10->9->8->7->2
 */
package com.dsa.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author KowlutlaSwamy
 *
 */
public class L11ReverseSinglyLinkedListIterative {

    /**
     * Reverses a singly linked list using a stack to store node values.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), as it uses a stack to store all node values.
     *
     * @param head The head node of the linked list.
     * @return The head node of the reversed linked list.
     */
    public static Node reverseList1(Node head) {
        Deque<Integer> stack = new ArrayDeque<>();
        Node current = head;

        // Push all node values onto the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;

        // Pop values from the stack and reassign to nodes
        while (current != null) {
            current.data = stack.pop();
            current = current.next;
        }
        return head;
    }

    /**
     * Reverses a singly linked list by reversing the node pointers.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as it uses a constant amount of extra space.
     *
     * @param head The head node of the linked list.
     * @return The head node of the reversed linked list.
     */
    public static Node reverseList2(Node head) {
        Node current = head;
        Node prev = null, next = null;

        // Reverse the pointers of the nodes
        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev to current node
            current = next; // Move to the next node
        }
        return prev; // Return the new head of the reversed list
    }
}
