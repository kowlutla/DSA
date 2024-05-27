/**
 * 	Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
	
	Example 1:
	Input:
	N = 5
	value[] = {2, 4, 7, 8, 9}
	k = 3
	Output: 8 9 2 4 7
	Explanation:
	Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
	Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
	Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

	Example 2:
	Input:
	N = 8
	value[] = {1, 2, 3, 4, 5, 6, 7, 8}
	k = 4
	Output: 5 6 7 8 1 2 3 4

 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L31RotateLinkedListByKAntiClockwise {

    /**
     * Rotates the linked list k times anti-clockwise by rotating one node at a time.
     *
     * @param head the head of the linked list
     * @param k the number of rotations
     * @return the new head of the rotated linked list
     * 
     * Time complexity: O(k * n) where n is the length of the list
     * Space complexity: O(1)
     */
    public static Node rotate1(Node head, int k) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, no rotation is needed
        }

        // Rotate the list one node at a time, k times
        for (int i = 1; i <= k; i++) {
            head = rotateByOneAntiClock(head);
        }
        return head;
    }

    /**
     * Rotates the linked list by one node in an anti-clockwise direction.
     *
     * @param head the head of the linked list
     * @return the new head of the rotated linked list
     */
    private static Node rotateByOneAntiClock(Node head) {
        Node current = head;
        Node next = head.next;

        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }

        // Point the last node to the current head
        current.next = head;
        head.next = null; // Set the next of the current head to null
        head = next; // Update the head to the next node

        return head;
    }

    /**
     * Rotates the linked list k times anti-clockwise in one pass.
     *
     * @param head the head of the linked list
     * @param k the number of rotations
     * @return the new head of the rotated linked list
     * 
     * Time complexity: O(n) where n is the length of the list
     * Space complexity: O(1)
     */
    public static Node rotate2(Node head, int k) {
        if (head == null || k == 0) {
            return head; // If the list is empty or no rotation is needed, return the head
        }

        Node current = head;

        // Traverse to the k-th node
        while (k-- > 1) {
            current = current.next;
        }

        if (current.next == null) {
            return head; // If k is greater than or equal to the number of nodes, no rotation is needed
        }

        Node next = current.next;
        Node lastNode = current;

        // Traverse to the end of the list
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        // Perform the rotation
        lastNode.next = head;
        current.next = null;
        head = next;

        return head;
    }

    /**
     * Rotates the linked list k times anti-clockwise using reverse operations.
     *
     * @param head the head of the linked list
     * @param k the number of rotations
     * @return the new head of the rotated linked list
     * 
     * Time complexity: O(n) where n is the length of the list
     * Space complexity: O(1)
     */
    public static Node rotate3(Node head, int k) {
        int n = getLength(head); // Get the length of the list

        if (n == k) {
            return head; // If k is equal to the length of the list, no rotation is needed
        }

        Node newHead = reverse(head); // Reverse the entire list
        int count1 = 1;
        Node current1 = newHead;

        // Traverse to the (n-k)-th node
        while (count1 < (n - k)) {
            count1++;
            current1 = current1.next;
        }

        Node current2 = current1.next;
        current1.next = null; // Split the list into two parts

        Node firstHead = reverse(newHead); // Reverse the first part
        Node secondHead = reverse(current2); // Reverse the second part

        newHead.next = secondHead; // Connect the two parts
        head = firstHead; // Update the head

        return head;
    }

    /**
     * Calculates the length of the linked list.
     *
     * @param head the head of the linked list
     * @return the length of the linked list
     */
    private static int getLength(Node head) {
        Node current = head;
        int len = 0;

        // Traverse the entire list to count the number of nodes
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }

    /**
     * Reverses the linked list.
     *
     * @param head the head of the linked list
     * @return the new head of the reversed linked list
     */
    private static Node reverse(Node head) {
        Node current = head;
        Node next = null;
        Node prev = null;

        // Reverse the pointers of the nodes
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
