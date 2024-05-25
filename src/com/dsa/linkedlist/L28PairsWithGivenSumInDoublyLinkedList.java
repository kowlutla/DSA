/**
 * 	Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
	
	Example 1:
	Input:  
	1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
	target = 7
	Output: (1, 6), (2,5)
	Explanation: We can see that there are two pairs 
	(1, 6) and (2,5) with sum 7.
	 
	
	Example 2:
	Input: 
	1 <-> 5 <-> 6
	target = 6
	Output: (1,5)
	Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 */
package com.dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class L28PairsWithGivenSumInDoublyLinkedList {

    /**
     * Finds all pairs of nodes in a doubly linked list that sum up to a given target.
     *
     * Time Complexity: O(N), where N is the number of nodes in the linked list.
     * Space Complexity: O(1), ignoring the space required for the result list.
     *
     * @param target The target sum for the pairs.
     * @param head The head of the doubly linked list.
     * @return A list of pairs where each pair consists of two integers that add up to the target sum.
     */
    public static List<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // If the list is empty or has only one node, return an empty result list
        if (head == null || head.next == null) {
            return result;
        }

        // Find the tail of the list
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node current1 = head;
        Node current2 = tail;

        // Use two pointers to find pairs that sum up to the target
        while (current1.data < current2.data) {
            int sum = current1.data + current2.data;

            if (sum == target) { // If the sum equals the target, add the pair to the result list
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(current1.data);
                pair.add(current2.data);
                result.add(pair);
                current1 = current1.next; // Move the first pointer forward
                current2 = current2.prev; // Move the second pointer backward
            } else if (sum < target) { // If the sum is less than the target, move the first pointer forward
                current1 = current1.next;
            } else { // If the sum is greater than the target, move the second pointer backward
                current2 = current2.prev;
            }
        }

        return result;
    }
}
