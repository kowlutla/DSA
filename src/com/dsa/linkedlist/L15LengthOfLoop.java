/**
 * 	Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains a loop or not and if the loop is present then return the count of nodes in a loop or else return 0. C is the position of the node to which the last node is connected. If it is 0 then no loop.
	
	
	
	Example 1:
	
	Input:
	N = 10
	value[]={25,14,19,33,10,21,39,90,58,45}
	C = 4
	Output: 7
	Explanation: The loop is 45->33. So
	length of loop is 33->10->21->39->
	90->58->45 = 7. The number 33 is
	connected to the last node to form the
	loop because according to the input the
	4th node from the beginning(1 based
	index) will be connected to the last
	node for the loop.
	Example 2:
	
	Input:
	N = 2
	value[] = {1,0}
	C = 1
	Output: 2
	Explanation: The length of the loop
	is 2.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L15LengthOfLoop {

    /**
     * Finds the length of the loop in a linked list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no additional space is used.
     *
     * @param head The head node of the linked list.
     * @return The length of the loop, or 0 if no loop is found.
     */
    public static int countNodesinLoop(Node head) {
        Node fast = head; // Initialize the fast pointer
        Node slow = head; // Initialize the slow pointer

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
            // If slow and fast pointers meet, a loop is detected
            if (slow == fast) {
                return findLength(slow); // Find the length of the loop
            }
        }
        return 0; // No loop detected
    }

    /**
     * Helper method to find the length of the loop.
     *
     * @param node A node inside the loop.
     * @return The length of the loop.
     */
    private static int findLength(Node node) {
        int count = 0; // Initialize count
        Node current = node; // Start from the given node

        // Traverse the loop until we return to the starting node
        do {
            count++; // Increment count
            current = current.next; // Move to the next node
        } while (current != node); // Continue until we are back at the start
        return count; // Return the length of the loop
    }
}
