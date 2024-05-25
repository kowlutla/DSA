/**
 * 	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.

	Example 2:
	Input: l1 = [0], l2 = [0]
	Output: [0]
	Example 3:
	
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
	
	It is guaranteed that the list represents a number that does not have leading zeros.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L24AddTwoNumbers {

    /**
     * Adds two numbers represented by linked lists.
     *
     * Time Complexity: O(max(N, M)), where N and M are the lengths of the two linked lists.
     * Space Complexity: O(max(N, M)), the space for the output list.
     *
     * @param l1 The head of the first linked list.
     * @param l2 The head of the second linked list.
     * @return The head of the linked list representing the sum.
     */
    public Node addTwoNumbers(Node l1, Node l2) {
        Node current1 = l1;  // Pointer for traversing the first list
        Node current2 = l2;  // Pointer for traversing the second list
        Node sumHead = new Node(-1);  // Dummy head for the result list
        Node lastSumPos = sumHead;  // Pointer for the last position in the result list

        int carry = 0;  // Initialize carry to 0

        // Traverse both lists until the end of both
        while (current1 != null || current2 != null) {

            int digit1 = current1 == null ? 0 : current1.data;  // Get the value from the first list or 0 if null
            int digit2 = current2 == null ? 0 : current2.data;  // Get the value from the second list or 0 if null
            int sum = digit1 + digit2 + carry;  // Calculate the sum including the carry
            carry = sum / 10;  // Update carry for the next iteration
            Node newNode = new Node(sum % 10);  // Create a new node with the sum modulo 10
            lastSumPos.next = newNode;  // Append the new node to the result list

            // Move to the next nodes in both lists if available
            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;

            lastSumPos = newNode;  // Move the last position pointer to the new node
        }

        // If there's any remaining carry, add a new node at the end
        if (carry > 0) {
            Node newNode = new Node(1);
            lastSumPos.next = newNode;
        }

        return sumHead.next;  // Return the head of the resulting list, skipping the dummy head
    }
}
