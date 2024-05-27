/**
 * 	Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
	(i) a next pointer to the next node,
	(ii) a bottom pointer to a linked list where this node is head.
	Each of the sub-linked-list is in sorted order.
	Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
	
	Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
	For more clarity have a look at the printList() function in the driver code.
	
	 
	
	Example 1:
	
	Input:
	5 -> 10 -> 19 -> 28
	|     |     |     | 
	7     20    22   35
	|           |     | 
	8          50    40
	|                 | 
	30               45
	Output:  5-> 7-> 8- > 10 -> 19-> 20->
	22-> 28-> 30-> 35-> 40-> 45-> 50.
	Explanation:
	The resultant linked lists has every 
	node in a single level.
	(Note: | represents the bottom pointer.)
	 
	
	Example 2:
	
	Input:
	5 -> 10 -> 19 -> 28
	|          |                
	7          22   
	|          |                 
	8          50 
	|                           
	30              
	Output: 5->7->8->10->19->22->28->30->50
	Explanation:
	The resultant linked lists has every
	node in a single level.
	
	(Note: | represents the bottom pointer.)
 */
package com.dsa.linkedlist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author KowlutlaSwamy
 *
 */
public class L32FlatteningLinkedList {

    /**
     * Flattens a multilevel linked list by collecting all elements into a list, sorting them,
     * and then creating a new flattened list.
     *
     * @param root the root of the multilevel linked list
     * @return the head of the new flattened linked list
     * 
     * Time complexity: O(n log n) where n is the total number of nodes
     * Space complexity: O(n)
     */
    public static Node flatten1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        // Traverse through the entire linked list
        Node current1 = root;
        while (current1 != null) {
            Node current2 = current1;
            // Traverse the bottom linked list
            while (current2 != null) {
                list.add(current2.data); // Add data to the list
                current2 = current2.bottom;
            }
            current1 = current1.next;
        }

        // Sort the list of all node data
        Collections.sort(list);

        // Create a new linked list with sorted data
        Node newHead = new Node(list.get(0));
        Node current = newHead;
        for (int i = 1; i < list.size(); i++) {
            Node newNode = new Node(list.get(i));
            current.bottom = newNode;
            current = newNode;
        }

        return newHead;
    }

    /**
     * Flattens a multilevel linked list using divide and conquer by merging lists recursively.
     *
     * @param root the root of the multilevel linked list
     * @return the head of the new flattened linked list
     * 
     * Time complexity: O(n log k) where n is the total number of nodes and k is the number of lists
     * Space complexity: O(1)
     */
    public static Node flatten2(Node root) {
        if (root == null || root.next == null) {
            return root; // Base case: If the list is empty or has only one list, return root
        }

        // Recursively flatten the rest of the list and merge with the current list
        return merge(root, flatten2(root.next));
    }

    /**
     * Merges two sorted linked lists into one sorted list.
     *
     * @param head1 the head of the first linked list
     * @param head2 the head of the second linked list
     * @return the head of the merged linked list
     */
    private static Node merge(Node head1, Node head2) {
        Node dummy = new Node(0); // Dummy node to act as the start of the merged list

        Node current1 = head1;
        Node current2 = head2;
        Node current = dummy;

        // Traverse both lists and merge them
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                current.bottom = current1;
                current = current1;
                current1 = current1.bottom;
            } else {
                current.bottom = current2;
                current = current2;
                current2 = current2.bottom;
            }
            current.next = null; // Ensure the next pointer is null
        }

        // If there are remaining nodes in either list, attach them
        if (current1 != null) {
            current.bottom = current1;
        }
        if (current2 != null) {
            current.bottom = current2;
        }

        return dummy.bottom; // Return the head of the merged list
    }

    /**
     * Flattens a multilevel linked list by iteratively merging each list into a single list.
     *
     * @param root the root of the multilevel linked list
     * @return the head of the new flattened linked list
     * 
     * Time complexity: O(n log k) where n is the total number of nodes and k is the number of lists
     * Space complexity: O(1)
     */
    public static Node flatten3(Node root) {
        Node current = root;
        Node prev = null;
        Node next = null;

        // Traverse through the entire linked list
        while (current != null) {
            next = current.next;
            prev = merge(current, prev); // Merge the current list with the previous merged list
            current = next;
        }
        return prev; // Return the head of the merged list
    }

    private static class Node {
        int data;
        Node next;
        Node bottom; // To use for doubly linked list

        public Node(int d) {
            data = d;
        }
    }
}
