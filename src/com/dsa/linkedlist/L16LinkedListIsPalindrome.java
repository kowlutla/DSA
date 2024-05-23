/**
 * 	Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
	
	Example 1:
	
	Input:
	N = 3
	value[] = {1,2,1}
	Output: 1
	Explanation: The given linked list is
	1 2 1 , which is a palindrome and
	Hence, the output is 1.
	Example 2:
	
	Input:
	N = 4
	value[] = {1,2,3,4}
	Output: 0
	Explanation: The given linked list
	is 1 2 3 4 , which is not a palindrome
	and Hence, the output is 0.
 */
package com.dsa.linkedlist;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class L16LinkedListIsPalindrome {

    /**
     * Checks if a linked list is a palindrome using a stack.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), due to the stack storage.
     *
     * @param head The head node of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to store node data
        Node current = head;
        while (current != null) {
            stack.push(current.data); // Push all node data onto the stack
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.data != stack.pop()) { // Compare each node data with the top of the stack
                return false; // Return false if a mismatch is found
            }
            current = current.next;
        }
        return true; // Return true if no mismatch is found
    }

    /**
     * Checks if a linked list is a palindrome by reversing the second half of the list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no additional space is used except for a few pointers.
     *
     * @param head The head node of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true; // A list with 0 or 1 node is always a palindrome
        }

        Node slow = head; // Initialize slow pointer
        Node fast = head; // Initialize fast pointer

        // Move fast pointer two steps and slow pointer one step at a time to find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node revHead = reverse(slow); // Reverse the second half of the list

        Node current1 = head;
        Node current2 = revHead;

        // Compare the first half and the reversed second half of the list
        while (current2 != null) {
            if (current1.data != current2.data) {
                return false; // Return false if a mismatch is found
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true; // Return true if no mismatch is found
    }

    /**
     * Reverses a linked list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no additional space is used except for a few pointers.
     *
     * @param head The head node of the linked list to be reversed.
     * @return The new head node of the reversed linked list.
     */
    private static Node reverse(Node head) {
        Node prev = null; // Initialize previous pointer
        Node next; // Initialize next pointer
        Node current = head; // Start with the head node

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move previous pointer to the current node
            current = next; // Move to the next node
        }

        return prev; // Return the new head of the reversed list
    }
}
