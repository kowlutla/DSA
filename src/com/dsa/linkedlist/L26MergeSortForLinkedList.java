/**
 * 	Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
	Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.
	
	Example 1:
	Input:
	N = 5
	value[]  = {3,5,2,4,1}
	Output: 1 2 3 4 5
	Explanation: After sorting the given
	linked list, the resultant matrix
	will be 1->2->3->4->5.

	Example 2:
	Input:
	N = 3
	value[]  = {9,15,0}
	Output: 0 9 15
	Explanation: After sorting the given
	linked list , resultant will be
	0->9->15.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L26MergeSortForLinkedList {

    /**
     * Sorts a linked list using merge sort.
     *
     * Time Complexity: O(N log N), where N is the number of nodes in the linked list.
     * Space Complexity: O(log N) due to the recursive stack space.
     *
     * @param head The head of the linked list.
     * @return The head of the sorted linked list.
     */
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: if the list is empty or has one element, it is already sorted.
        }

        Node mid = getMiddle(head); // Find the middle of the list.
        Node leftHead = head; // Left half starts from the head.
        Node rightHead = mid.next; // Right half starts from the node after the middle.
        mid.next = null; // Split the list into two halves.

        // Recursively sort both halves.
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        // Merge the sorted halves and return the merged list.
        return merge(leftHead, rightHead);
    }

    /**
     * Merges two sorted linked lists.
     *
     * @param head1 The head of the first sorted linked list.
     * @param head2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    private static Node merge(Node head1, Node head2) {
        Node result = new Node(-1); // Dummy node to simplify merging logic.
        Node current3 = result; // Pointer to build the merged list.
        Node current1 = head1; // Pointer to traverse the first list.
        Node current2 = head2; // Pointer to traverse the second list.

        // Traverse both lists and merge them based on their values.
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                current3.next = current1;
                current3 = current1;
                current1 = current1.next;
            } else {
                current3.next = current2;
                current3 = current2;
                current2 = current2.next;
            }
        }

        // Append the remaining nodes from the first list, if any.
        while (current1 != null) {
            current3.next = current1;
            current3 = current1;
            current1 = current1.next;
        }

        // Append the remaining nodes from the second list, if any.
        while (current2 != null) {
            current3.next = current2;
            current3 = current2;
            current2 = current2.next;
        }

        return result.next; // Return the merged list, skipping the dummy node.
    }

    /**
     * Finds the middle node of the linked list.
     *
     * @param head The head of the linked list.
     * @return The middle node of the linked list.
     */
    private static Node getMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        Node prev = null;

        // Use the fast and slow pointer approach to find the middle of the list.
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev; // Return the node before the middle node to split the list.
    }
}
