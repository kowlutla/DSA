/**
 * 	Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the doubly linked list.
	
	Example 1:
	
	Input:
	LinkedList: 2<->4<->5
	p = 2, x = 6 
	Output: 2 4 5 6
	Explanation: p = 2, and x = 6. So, 6 is
	inserted after p, i.e, at position 3
	(0-based indexing).
	Example 2:
	
	Input:
	LinkedList: 1<->2<->3<->4
	p = 0, x = 44
	Output: 1 44 2 3 4
	Explanation: p = 0, and x = 44 . So, 44
	is inserted after p, i.e, at position 1
	(0-based indexing).
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L7DoublyLinkedListAtNthPosition {

    /**
     * Adds a new node with the given data at the specified position in a doubly linked list.
     *
     * @param head The head node of the doubly linked list.
     * @param pos The position to insert the new node at (0-based index).
     * @param data The data for the new node.
     */
    public static void addNode(Node head, int pos, int data) {

        // Create a new node with the given data
        Node newNode = new Node(data);
        // Initialize current to head and set currentPos to 0
        Node current = head;
        int currentPos = 0;

        // Traverse the list until currentPos is less than pos
        while (currentPos < pos) {
            current = current.next; // Move to the next node
            currentPos++; // Increment current position
        }

        // Set the new node's next to the current node's next
        newNode.next = current.next;
        // Set the new node's previous to the current node
        newNode.prev = current;
        // Set the current node's next to the new node
        current.next = newNode;

		// NOT NEEDED: But in case they asked to add existing nodeIf the new
		// node's next is not null, set its previous to the new node
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
    }
}
