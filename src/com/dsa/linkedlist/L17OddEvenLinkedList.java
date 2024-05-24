/**
 * 	Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
	The first node is considered odd, and the second node is even, and so on.
	Note that the relative order inside both the even and odd groups should remain as it was in the input.
	You must solve the problem in O(1) extra space complexity and O(n) time complexity.
	
	Example 1:
	Input: head = [1,2,3,4,5]
	Output: [1,3,5,2,4]

	Example 2:
	Input: head = [2,1,3,5,6,4,7]
	Output: [2,3,6,7,1,5,4]
 
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L17OddEvenLinkedList {

	public static Node oddEvenList1(Node head) {
		Node even = new Node(-1); // Dummy node for the even list
		Node odd = new Node(-1); // Dummy node for the odd list

		Node lastEven = even;
		Node lastOdd = odd;

		Node current = head;
		int index = 1;

		// Traverse the original list and rearrange nodes in place
		while (current != null) {
			if (index % 2 == 0) { // if it is even index
				lastEven.next = current; // Attach to the even list
				lastEven = current;
			} else {
				lastOdd.next = current; // Attach to the odd list
				lastOdd = current;
			}
			index++;
			current = current.next;
		}

		lastEven.next = null; // End the even list
		lastOdd.next = even.next; // Link the end of odd list to the start of
									// even list
		head = odd.next; // Update head to the start of the odd list
		return head; // Return the head of the new list
	}

	/**
     * Reorders the linked list such that all odd-indexed nodes are followed by even-indexed nodes.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     * 
     * @param head The head node of the linked list.
     * @return The head of the reordered linked list.
     */
    public static Node oddEvenList2(Node head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, return head.
        }
        
        Node odd = head; // Pointer for odd-indexed nodes
        Node even = head.next; // Pointer for even-indexed nodes
        Node lastOdd = odd;
        Node lastEven = even;

        // Traverse the list and reorder nodes to group odd-indexed nodes followed by even-indexed nodes.
        while (lastEven != null && lastEven.next != null) {
            lastOdd.next = lastEven.next; // Link the next odd node
            lastOdd = lastEven.next; // Move the odd pointer
            lastEven.next = lastOdd.next; // Link the next even node
            lastEven = lastOdd.next; // Move the even pointer
        }

        lastOdd.next = even; // Attach the even list to the end of the odd list
        return odd; // Return the head of the reordered list
    }
}
