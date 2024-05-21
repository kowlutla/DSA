/**
 * 	Given a doubly linked list and a position. The task is to delete a node from given position (position starts from 1) in a doubly linked list.

	Example 1:
	Input:
	LinkedList = 1 <--> 3 <--> 4 
	x = 3
	Output: 1 3  
	Explanation: After deleting the node at
	position 3 (position starts from 1),
	the linked list will be now as 1->3.

	Example 2:
	Input:
	LinkedList = 1 <--> 5 <--> 2 <--> 9  
	x = 1
	Output: 5 2 9
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L8DeleteNodeInDoublyLinkedList {

    /**
     * Deletes the node at the specified position in a doubly linked list.
     *
     * @param head The head node of the doubly linked list.
     * @param x The position (1-based index) of the node to be deleted.
     * @return The head node of the modified doubly linked list.
     */
    public static Node deleteNode(Node head, int x) {
        
        // If the node to be deleted is the head node
        if (x == 1) {
            // Update the head to the next node
            head.next.prev = null;
            head = head.next;
            return head;
        }

        int pos = 1;
        Node current = head;

        // Traverse the list to find the node at position x
        while (pos < x) {
            current = current.next;
            pos++;
        }

        // Update the previous node's next pointer to skip the current node
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        // Update the next node's previous pointer to skip the current node
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head; // Return the head of the modified list
    }
}
