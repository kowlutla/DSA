/**
 * 	Given a linked list of N nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.
	
	Example 1:
	Input:
	N = 3
	value[] = {1,3,4}
	x(position at which tail is connected) = 2
	Output: True
	Explanation: In above test case N = 3.
	The linked list with nodes N = 3 is
	given. Then value of x=2 is given which
	means last node is connected with xth
	node of linked list. Therefore, there
	exists a loop.

	Example 2:
	Input:
	N = 4
	value[] = {1,8,3,4}
	x = 0
	Output: False
	Explanation: For N = 4 ,x = 0 means
	then lastNode->next = NULL, then
	the Linked list does not contains
	any loop.
 */
package com.dsa.linkedlist;

import java.util.HashSet;

/**
 * @author KowlutlaSwamy
 *
 */
public class L13DetectLoopInLinkedList {

    /**
     * Detects a loop in a linked list using a HashSet.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), for storing nodes in the HashSet.
     *
     * @param head The head node of the linked list.
     * @return true if a loop is detected, false otherwise.
     */
    public static boolean detectLoop1(Node head) {
        // Create a HashSet to store visited nodes
        HashSet<Node> set = new HashSet<>();
        Node current = head;

        // Traverse the list
        while (current != null) {
            // If the current node is already in the set, a loop is detected
            if (!set.add(current))
                return true;
            current = current.next;
        }

        return false; // No loop detected
    }

    /**
     * Detects a loop in a linked list using the Floyd’s Cycle-Finding Algorithm.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no additional space is used.
     *
     * @param head The head node of the linked list.
     * @return true if a loop is detected, false otherwise.
     */
    public static boolean detectLoop2(Node head) {
        Node fast = head;
        Node slow = head;

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, a loop is detected
            if (slow == fast) {
                return true;
            }
        }
        return false; // No loop detected
    }
}
