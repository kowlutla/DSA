/**
 * 	Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.
	
	Example 1:
	Input:
	n = 6
	1<->1<->1<->2<->3<->4
	Output:
	1<->2<->3<->4
	Explanation:
	Only the first occurance of node with value 1 is 
	retained, rest nodes with value = 1 are deleted.

	Example 2:
	Input:
	n = 7
	1<->2<->2<->3<->3<->4<->4
	Output:
	1<->2<->3<->4
	Explanation:
	Only the first occurance of nodes with values 2,3 and 4 are 
	retained, rest repeating nodes are deleted.
	Your Task:
	You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.  Your function should return a pointer to a linked list with no duplicate element.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L29RemoveDuplicatesFromSortedDoublyLinkedList {

    /**
     * Removes duplicates from a sorted doubly linked list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list.
     * Space Complexity: O(1), as we are modifying the list in place without using additional data structures.
     *
     * @param head The head of the sorted doubly linked list.
     * @return The head of the list after removing duplicates.
     */
    public static Node removeDuplicates(Node head) {
        Node current1 = head;

        while (current1 != null) {
            Node current2 = current1.next;

            // Move current2 to the next distinct node
            while (current2 != null && current2.data == current1.data) {
                current2 = current2.next;
            }

            // Update the next pointer of current1 to the next distinct node
            current1.next = current2;

            // If the next distinct node is not null, update its prev pointer
            if (current2 != null) {
                current2.prev = current1;
            }

            // Move to the next distinct node
            current1 = current2;
        }
        return head;
    }
}
