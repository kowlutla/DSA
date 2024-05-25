/**
 *	Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
	If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
	If the input linked list has single node, then it should return NULL.
	
	Example 1:
	Input:
	LinkedList: 1->2->3->4->5
	Output: 
	1 2 4 5

	Example 2:
	Input:
	LinkedList: 2->4->6->7->5->1
	Output: 
	2 4 6 5 1 
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L20DeleteMiddleElementOfList {

    /**
     * Deletes the middle node from the linked list.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     * 
     * @param head The head node of the linked list.
     * @return The head of the modified linked list with the middle node removed.
     */
    public static Node deleteMid(Node head) {
        if (head == null || head.next == null) {
            return null; // If list is empty or has only one node, return null
        }

        Node fast = head;
        Node slow = head;
        Node prev = null;

        // Move fast by 2 steps and slow by 1 step to find the middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove the middle node
        prev.next = slow.next;
        return head;
    }
}
