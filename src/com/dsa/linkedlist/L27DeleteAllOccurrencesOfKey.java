/**
 * 	You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.
	
	Example1:
	Input: 
	2<->2<->10<->8<->4<->2<->5<->2
	2
	Output: 
	10<->8<->4<->5
	Explanation: 
	All Occurences of 2 have been deleted.
	
	Example2:
	Input: 
	9<->1<->3<->4<->5<->1<->8<->4
	9
	Output: 
	1<->3<->4<->5<->1<->8<->4
	Explanation: 
	All Occurences of 9 have been deleted.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L27DeleteAllOccurrencesOfKey {

    /**
     * Deletes all occurrences of a given key in a doubly linked list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list.
     * Space Complexity: O(1).
     *
     * @param head The head of the doubly linked list.
     * @param x The key to be deleted.
     * @return The head of the modified linked list.
     */
    public static Node deleteAllOccurOfKey1(Node head, int x) {

        // Remove occurrences of x from the head of the list
        while (head != null && head.data == x) {
            head = head.next; // Move head to the next node
        }

        Node current = head; // Initialize current node to head

        // Traverse the list and remove nodes with value x
        while (current != null) {
            if (current.data == x) { // Check if current node's data equals x
                Node prev = current.prev; // Store the previous node
                Node next = current.next; // Store the next node
                if (prev != null) {
                    prev.next = next; // Update previous node's next pointer
                }
                if (next != null) {
                    next.prev = prev; // Update next node's prev pointer
                }
            }
            current = current.next; // Move to the next node
        }

        return head; // Return the head of the modified list
    }

    /**
     * Another approach to delete all occurrences of a given key in a doubly linked list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list.
     * Space Complexity: O(1).
     *
     * @param head The head of the doubly linked list.
     * @param x The key to be deleted.
     * @return The head of the modified linked list.
     */
    public static Node deleteAllOccurOfKey2(Node head, int x) {

        Node current = head; // Initialize current node to head

        // Traverse the list and remove nodes with value x
        while (current != null) {
            Node next = current.next; // Store the next node
            if (current.data == x) { // Check if current node's data equals x
                if (current == head) {
                    head = next; // Update head if current node is the head
                }
                if (current.prev != null) {
                    current.prev.next = next; // Update previous node's next pointer
                }
                if (next != null) {
                    next.prev = current.prev; // Update next node's prev pointer
                }
            }
            current = next; // Move to the next node
        }

        return head; // Return the head of the modified list
    }
}
