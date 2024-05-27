/**
 * 	Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).
	
	Example 1:
	Input:
	LinkedList: 1->2->2->4->5->6->7->8
	K = 4
	Output: 4 2 2 1 8 7 6 5 
	Explanation: 
	The first 4 elements 1,2,2,4 are reversed first 
	and then the next 4 elements 5,6,7,8. Hence, the 
	resultant linked list is 4->2->2->1->8->7->6->5.

	Example 2:
	Input:
	LinkedList: 1->2->3->4->5
	K = 3
	Output: 3 2 1 5 4 
	Explanation: 
	The first 3 elements are 1,2,3 are reversed 
	first and then elements 4,5 are reversed.Hence, 
	the resultant linked list is 3->2->1->5->4.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L30ReverseLinkedListInGroups {

    /**
     * Reverses the linked list in groups of size k.
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list.
     * Space Complexity: O(1), as we are reversing the list in place.
     *
     * @param head The head of the linked list.
     * @param k The size of the groups to reverse.
     * @return The head of the modified list after reversing in groups.
     */
    public static Node reverse(Node head, int k) {
        Node current = head;
        Node prevLast = null;
        Node next = null;

        // Process the list in chunks of size k
        while (current != null) {
            Node kthNode = getKthNode(current, k);
            next = kthNode.next; // Store the next node to continue processing
            kthNode.next = null; // Temporarily terminate the list at kth node

            reverseGroup(current); // Reverse the current group

            // Connect the reversed group to the previous part of the list
            if (current == head) {
                head = kthNode; // Update the head if this is the first group
            } else {
                prevLast.next = kthNode; // Connect the previous group's last node to the current group's head
            }

            prevLast = current; // Update the last node of the current group for the next iteration
            current = next; // Move to the next group
        }

        return head;
    }

    /**
     * Returns the k-th node from the current node.
     *
     * @param head The starting node.
     * @param k The number of nodes to move forward.
     * @return The k-th node from the current node or the last node if the list is shorter than k.
     */
    private static Node getKthNode(Node head, int k) {
        Node current = head;
        Node prev = null;
        while (current != null && k-- > 0) {
            prev = current;
            current = current.next;
        }
        return prev; // Return the k-th node or the last node reached
    }

    /**
     * Reverses the linked list starting from the given head.
     *
     * @param head The head of the segment to reverse.
     * @return The new head of the reversed segment.
     */
    private static Node reverseGroup(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the pointer
            prev = current; // Move the prev pointer forward
            current = next; // Move the current pointer forward
        }
        return prev; // Return the new head of the reversed list
    }
}
