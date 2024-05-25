/**
 * 	Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

	Example 1:
	
	Input:
	N = 8
	value[] = {1,2,2,1,2,0,2,2}
	Output: 0 1 1 2 2 2 2 2
	Explanation: All the 0s are segregated
	to the left end of the linked list,
	2s to the right end of the list, and
	1s in between.
	Example 2:
	
	Input:
	N = 4
	value[] = {2,2,0,1}
	Output: 0 1 2 2
	Explanation: After arranging all the
	0s,1s and 2s in the given format,
	the output will be 0 1 2 2.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L21SortListOf01and2s {

    /**
     * Segregates the linked list containing 0s, 1s, and 2s into sorted order.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     *
     * @param head The head node of the input linked list.
     * @return The head of the modified linked list with sorted 0s, 1s, and 2s.
     */
    public static Node segregate(Node head) {
        // Dummy nodes for 0s, 1s, and 2s lists
        Node zeroHead = new Node(0); // Dummy head for list of 0s
        Node oneHead = new Node(1);  // Dummy head for list of 1s
        Node twoHead = new Node(2);  // Dummy head for list of 2s

        // Pointers to the last node of 0s, 1s, and 2s lists
        Node lastZero = zeroHead; // Pointer to last node in 0s list
        Node lastOne = oneHead;   // Pointer to last node in 1s list
        Node lastTwo = twoHead;   // Pointer to last node in 2s list

        Node current = head; // Current node in the original list

        // Traverse the original list and link nodes to corresponding lists
        while (current != null) {
            if (current.data == 0) {
                // If the current node is 0, append it to the 0s list
                lastZero.next = current;
                lastZero = current;
            } else if (current.data == 1) {
                // If the current node is 1, append it to the 1s list
                lastOne.next = current;
                lastOne = current;
            } else {
                // If the current node is 2, append it to the 2s list
                lastTwo.next = current;
                lastTwo = current;
            }
            // Move to the next node in the original list
            current = current.next;
        }

        // Combine the lists of 0s, 1s, and 2s
        lastTwo.next = null;          // End the list of 2s
        lastOne.next = twoHead.next;  // Link 1s list to the 2s list
        lastZero.next = oneHead.next; // Link 0s list to the 1s list

        // Return the head of the new list (skipping the dummy zero node)
        return zeroHead.next;
    }
}