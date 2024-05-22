/**
 * 	Given a singly linked list of N nodes.
	The task is to find the middle of the linked list. For example, if the linked list is
	1-> 2->3->4->5, then the middle node of the list is 3.
	If there are two middle nodes(in case, when N is even), print the second middle element.
	For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.
	
	Example 1:
	Input:
	LinkedList: 1->2->3->4->5
	Output: 3 
	Explanation: 
	Middle of linked list is 3.

	Example 2: 
	Input:
	LinkedList: 2->4->6->7->5->1
	Output: 7 
	Explanation: 
	Middle of linked list is 7.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L10MiddleElementOfLinkedList {

    /**
     * Finds the middle element of a linked list by first calculating its length.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as it only uses a constant amount of extra space.
     *
     * @param head The head node of the linked list.
     * @return The data of the middle node.
     */
    public static int getMiddle1(Node head) {
        int len = 0; // Initialize length to 0
        Node current = head;

        // Traverse the list to calculate its length
        while (current != null) {
            current = current.next;
            len++;
        }

        int currentSize = 0; // Initialize currentSize to 0
        current = head;

        // Traverse the list again to find the middle element
        while (currentSize < len / 2) {
            current = current.next;
            currentSize++;
        }

        return current.data; // Return the data of the middle node
    }

    /**
     * Finds the middle element of a linked list using the two-pointer technique.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as it only uses a constant amount of extra space.
     *
     * @param head The head node of the linked list.
     * @return The data of the middle node.
     */
    public static int getMiddle2(Node head) {
        Node fast = head; // Initialize fast pointer
        Node slow = head; // Initialize slow pointer

        // Traverse the list with fast moving twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by one step
            fast = fast.next.next; // Move fast by two steps
        }

        return slow.data; // Return the data of the middle node
    }
}
