/**
 * 	Given the head of a linked list, remove the nth node from the end of the list and return its head.
	
	Example 1:
	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]

	Example 2:
	Input: head = [1], n = 1
	Output: []

	Example 3:
	Input: head = [1,2], n = 1
	Output: [1]
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L19RemoveNthNodeFromEnd {

    /**
     * Removes the Nth node from the end of the linked list.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     * 
     * @param head The head node of the linked list.
     * @param n The position from the end of the node to be removed.
     * @return The head of the modified linked list.
     */
    public Node removeNthFromEnd(Node head, int n) {
        Node current1 = head;
        Node current2 = head;

        // Move current1 n steps ahead
        while (n > 0) {
            if (current1 == null) {
                return head; // If n is greater than the length of the list, return the original head
            }
            n--;
            current1 = current1.next;
        }

        // If current1 is null, it means we need to remove the head node
        if (current1 == null) {
            return head.next;
        }

        // Move current1 to the end and current2 to the (len-n)th node
        while (current1.next != null) {
            current1 = current1.next;
            current2 = current2.next;
        }

        // Remove the nth node from the end
        current2.next = current2.next.next;
        return head;
    }
}
