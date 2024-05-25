/**
 * 	Given two numbers, num1 and num2, represented by linked lists of size n and m respectively. The task is to return a linked list that represents the sum of these two numbers.
	For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.
	Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
	
	Example 1:
	Input:
	n = 2
	num1 = 45 (4->5->null)
	m = 3
	num2 = 345 (3->4->5->null)
	Output: 
	3->9->0->null  
	Explanation: 
	For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).

	Example 2:
	Input:
	n = 4
	num1 = 0063 (0->0->6->3->null)
	m = 2
	num2 = 07 (0->7->null)
	Output: 
	7->0->null
	Explanation: 
	For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant linked list will be (7 0).
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L25AddTwoNumbersWithLeadingZeros {

    /**
     * Adds two numbers represented by linked lists, handling leading zeros.
     *
     * Time Complexity: O(max(N, M)), where N and M are the lengths of the two linked lists.
     * Space Complexity: O(max(N, M)), the space for the output list.
     *
     * @param num1 The head of the first linked list.
     * @param num2 The head of the second linked list.
     * @return The head of the linked list representing the sum.
     */
    public static Node addTwoNumbers(Node num1, Node num2) {
        Node current1 = num1;
        Node current2 = num2;
        
        // Skip leading zeros in the first list
        while (current1 != null && current1.data == 0) {
            current1 = current1.next;
        }

        // Skip leading zeros in the second list
        while (current2 != null && current2.data == 0) {
            current2 = current2.next;
        }

        // Reverse the non-zero part of the lists
        current1 = reverse(current1);
        current2 = reverse(current2);

        // If both lists are empty after removing leading zeros, return a single node with 0
        if (current1 == null && current2 == null) {
            return new Node(0);
        }
        // If the first list is empty, return the second list
        if (current1 == null) {
            return current2;
        }
        // If the second list is empty, return the first list
        if (current2 == null) {
            return current1;
        }

        Node sumHead = new Node(-1);  // Dummy head for the result list
        Node lastPosition = sumHead;  // Pointer for the last position in the result list

        int carry = 0;  // Initialize carry to 0

        // Traverse both lists and add corresponding digits
        while (current1 != null || current2 != null) {
            int digit1 = current1 == null ? 0 : current1.data;  // Get the value from the first list or 0 if null
            int digit2 = current2 == null ? 0 : current2.data;  // Get the value from the second list or 0 if null

            int sum = digit1 + digit2 + carry;  // Calculate the sum including the carry
            carry = sum >= 10 ? 1 : 0;  // Update carry for the next iteration
            Node newNode = new Node(sum % 10);  // Create a new node with the sum modulo 10
            lastPosition.next = newNode;  // Append the new node to the result list
            lastPosition = newNode;  // Move the last position pointer to the new node

            // Move to the next nodes in both lists if available
            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        // If there's any remaining carry, add a new node at the end
        if (carry > 0) {
            Node newNode = new Node(1);
            lastPosition.next = newNode;
        }

        return reverse(sumHead.next);  // Return the reversed result list, skipping the dummy head
    }

    /**
     * Reverses a linked list.
     *
     * @param head The head of the linked list to be reversed.
     * @return The head of the reversed linked list.
     */
    private static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node current = head;
        Node next = null;
        Node prev = null;

        // Reverse the pointers of the nodes
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;  // Move prev to current node
            current = next;  // Move to the next node
        }
        return prev;  // Return the new head of the reversed list
    }
}
