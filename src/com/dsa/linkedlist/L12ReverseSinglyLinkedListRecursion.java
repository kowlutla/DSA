/**
 * 	Given a linked list of N nodes. The task is to reverse this list.
	
	Example 1:
	Input:
	LinkedList: 1->2->3->4->5->6
	Output: 6 5 4 3 2 1
	Explanation: After reversing the list, 
	elements are 6->5->4->3->2->1.

	Example 2:
	Input:
	LinkedList: 2->7->8->9->10
	Output: 10 9 8 7 2
	Explanation: After reversing the list,
	elements are 10->9->8->7->2
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L12ReverseSinglyLinkedListRecursion {

    /**
     * Reverses a singly linked list using recursion.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), due to the recursion stack.
     *
     * @param head The head node of the linked list.
     * @return The head node of the reversed linked list.
     */
    public static Node reverseList(Node head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node newHead = reverseList(head.next);

        // Reverse the current node's pointer
        Node nextNode = head.next;
        nextNode.next = head;
        head.next = null;

        return newHead; // Return the new head of the reversed list
    }
}
