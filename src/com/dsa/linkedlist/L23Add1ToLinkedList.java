/**
 * 	A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

	Example 1:
	Input:
	LinkedList: 4->5->6
	Output: 457
	Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

	Example 2:
	Input:
	LinkedList: 1->2->3
	Output: 124 
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L23Add1ToLinkedList {

    /**
     * Adds 1 to a linked list representing a non-negative integer.
     *
     * Time Complexity: O(N), where N is the length of the linked list.
     * Space Complexity: O(1), no extra space is used.
     *
     * @param head The head of the linked list.
     * @return The head of the modified linked list after adding 1.
     */
    public static Node addOne(Node head) {
        // Reverse the linked list to facilitate addition from the least significant digit
        head = reverseList(head);
        
        Node current = head;
        Node prev = null;
        int carry = 1;  // Initialize carry as 1 since we are adding 1 to the list

        // Traverse the reversed list to add the carry
        while (current != null) {
            int sum = current.data + carry;  // Calculate the sum of the current node's data and carry
            carry = sum >= 10 ? 1 : 0;  // Determine the new carry
            current.data = sum % 10;  // Update the current node's data with the sum modulo 10
            prev = current;  // Move prev to the current node
            current = current.next;  // Move to the next node
			if (carry == 0) { //if carry is 0 then no change in subsequence nodes
				break;
			}
        }

        // If there is a remaining carry after the last node, add a new node with the carry
        if (carry == 1) {
            prev.next = new Node(1);
        }

        // Reverse the list back to its original order
        return reverseList(head);
    }

    /**
     * Reverses a linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     */
    private static Node reverseList(Node head) {
        Node current = head;
        Node prev = null, next = null;

        // Reverse the pointers of the nodes
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;  // Move prev to current node
            current = next;  // Move to the next node
        }
        return prev;  // Return the new head of the reversed list
    }
}
