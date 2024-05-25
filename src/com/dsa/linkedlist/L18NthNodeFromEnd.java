/**
 * 	Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
	
	Example 1:
	Input:
	N = 2
	LinkedList: 1->2->3->4->5->6->7->8->9
	Output: 8
	Explanation: In the first example, there
	are 9 nodes in linked list and we need
	to find 2nd node from end. 2nd node
	from end is 8.  

	Example 2:
	Input:
	N = 5
	LinkedList: 10->5->100->5
	Output: -1
	Explanation: In the second example, there
	are 4 nodes in the linked list and we
	need to find 5th from the end. Since 'n'
	is more than the number of nodes in the
	linked list, the output is -1.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L18NthNodeFromEnd {

    /**
     * Finds the Nth node from the end of the linked list using the length of the list.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than variables.
     * 
     * @param head The head node of the linked list.
     * @param n The position from the end to retrieve the node's data.
     * @return The data of the Nth node from the end, or -1 if the position is invalid.
     */
    public static int getNthFromLast1(Node head, int n) {
        int len = getLength(head); // Get the length of the list
        if (len < n) {
            return -1; // Return -1 if n is greater than the length of the list
        }

        Node current = head;
        int temp = len - n;
        while (temp-- > 0) {
            current = current.next; // Move to the (len - n)th node
        }
        return current.data; // Return the data of the Nth node from the end
    }

    /**
     * Helper method to calculate the length of the linked list.
     * 
     * @param head The head node of the linked list.
     * @return The length of the linked list.
     */
    private static int getLength(Node head) {
        int len = 0;
        Node current = head;
        while (current != null) {
            len++; // Increment the length counter
            current = current.next; // Move to the next node
        }
        return len; // Return the length of the list
    }

    /**
     * Finds the Nth node from the end of the linked list using two-pointer technique.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     * 
     * @param head The head node of the linked list.
     * @param n The position from the end to retrieve the node's data.
     * @return The data of the Nth node from the end, or -1 if the position is invalid.
     */
    public static int getNthFromLast2(Node head, int n) {
        Node current1 = head;

        while (n > 0) {
            if (current1 == null) {
                return -1; // Return -1 if the list has fewer than n nodes
            }
            current1 = current1.next; // Move the first pointer n steps forward
            n = n - 1;
        }

        Node current2 = head;
        while (current1 != null) {
            current1 = current1.next; // Move the first pointer to the end
            current2 = current2.next; // Move the second pointer n steps behind the first pointer
        }
        return current2.data; // Return the data of the second pointer
    }
}