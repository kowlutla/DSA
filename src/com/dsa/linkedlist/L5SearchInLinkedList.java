/**
 * 	Given a linked list of n nodes and a key , the task is to check if the key is present in the linked list or not.
	
	Example:
	
	Input:
	n = 4
	1->2->3->4
	Key = 3
	Output:
	True
	Explanation:
	3 is present in Linked List, so the function returns true.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L5SearchInLinkedList {

    /**
     * Method to search for a key in the linked list
     * 
     * @param n    The number of nodes in the linked list (not used in this method)
     * @param head The head node of the linked list
     * @param key  The key to search for in the linked list
     * @return     True if the key is found, false otherwise
     * 
     * Time Complexity: O(N) where N is the number of nodes in the linked list
     * Space Complexity: O(1) as no extra space is used
     */
    public static boolean searchKey(int n, Node head, int key) {
        Node current = head; // Start with the head node

        // Traverse the linked list until the end
        while (current != null) {
            // Check if the current node's data matches the key
            if (current.data == key) {
                return true; // Key found
            }
            current = current.next; // Move to the next node
        }

        return false; // Key not found
    }
}
