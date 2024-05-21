/**
 * 	Geek is learning data structures and is familiar with linked lists, but he's curious about how to access the previous element in a linked list in the same way that we access the next element. His teacher explains doubly linked lists to him.

	Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.
	
	Example 1:
	
	Input:
	n = 5
	arr = [1,2,3,4,5]
	Output:
	1 2 3 4 5
	Explanation: Linked list for the given array will be 1<->2<->3<->4<->5.
	Example 2:
	
	Input:
	n = 1
	arr = [1]
	Output:
	1
	Explanation: Linked list for the given array will be 1.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L6DoublyLinkedListInsertion {

    /**
     * Constructs a doubly linked list from an array.
     * 
     * @param arr The array of integers to create the doubly linked list from.
     * @return The head node of the constructed doubly linked list.
     * 
     * Time Complexity: O(N) where N is the number of elements in the array.
     * Space Complexity: O(1) for extra space used, excluding the space for the linked list nodes.
     */
    public static Node constructDLL(int[] arr) {

        // Get the length of the array
        int length = arr.length;

        // If the array is empty, return null
        if (length == 0) {
            return null;
        }

        // If the array has only one element, create a single node and return it
        if (length == 1) {
            return new Node(arr[0]);
        }

        // Create the head node with the first element of the array
        Node head = new Node(arr[0]);
        Node current = head; // Initialize current to head

        // Loop through the rest of the array elements to create the linked list
        for (int i = 1; i < length; i++) {
            // Create a new node with the current element
            Node newNode = new Node(arr[i]);

            // Set the previous pointer of the new node to the current node
            newNode.prev = current;

            // Set the next pointer of the current node to the new node
            current.next = newNode;

            // Move current to the new node
            current = current.next;
        }

        // Return the head of the constructed doubly linked list
        return head;
    }
}
