/**
 * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
	
	Example 1:
	Input:
	LinkList1 = 3->6->9->common
	LinkList2 = 10->common
	common = 15->30->NULL
	Output: 15
	Explanation:
	Y ShapedLinked List

	Example 2:
	Input: 
	Linked List 1 = 4->1->common
	Linked List 2 = 5->6->1->common
	common = 8->4->5->NULL
	Output: 8
	Explanation: 
	
	4              5
	|              |
	1              6
	 \             /
	  8   -----  1 
	   |
	   4
	   |
	  5
	  |
	  NULL       
 */
package com.dsa.linkedlist;

import java.util.HashSet;

/**
 * @author KowlutlaSwamy
 *
 */
public class L22IntersectionPointOfYLL {

    /**
     * Finds the intersection point of two linked lists using a nested loop approach.
     *
     * Time Complexity: O(N*M), where N is the length of list 1 and M is the length of list 2.
     * Space Complexity: O(1), no extra space is used.
     *
     * @param head1 The head of the first linked list.
     * @param head2 The head of the second linked list.
     * @return The data of the intersection node, or -1 if no intersection is found.
     */
    public static int intersectPoint1(Node head1, Node head2) {
        Node current1 = head1;  // Initialize pointer for the first list
        while (current1 != null) {
            Node current2 = head2;  // Initialize pointer for the second list
            while (current2 != null) {
                if (current1 == current2) {  // Check if nodes are the same
                    return current1.data;
                }
                current2 = current2.next;  // Move to the next node in the second list
            }
            current1 = current1.next;  // Move to the next node in the first list
        }
        return -1;
    }

    /**
     * Finds the intersection point of two linked lists using a HashSet to store visited nodes.
     *
     * Time Complexity: O(N+M), where N is the length of list 1 and M is the length of list 2.
     * Space Complexity: O(N), where N is the length of list 1 (size of the HashSet).
     *
     * @param head1 The head of the first linked list.
     * @param head2 The head of the second linked list.
     * @return The data of the intersection node, or -1 if no intersection is found.
     */
    public static int intersectPoint2(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node current1 = head1;  // Initialize pointer for the first list
        while (current1 != null) {
            set.add(current1);  // Add nodes to the set
            current1 = current1.next;
        }
        Node current2 = head2;  // Initialize pointer for the second list
        while (current2 != null) {
            if (!set.add(current2)) {  // Check if node already exists in the set
                return current2.data;
            }
            current2 = current2.next;
        }
        return -1;
    }

    /**
     * Finds the intersection point of two linked lists by adjusting their starting points.
     *
     * Time Complexity: O(N+M), where N is the length of list 1 and M is the length of list 2.
     * Space Complexity: O(1), no extra space is used.
     *
     * @param head1 The head of the first linked list.
     * @param head2 The head of the second linked list.
     * @return The data of the intersection node, or -1 if no intersection is found.
     */
    public static int intersectPoint3(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if (len1 > len2) {
            return intersectPoint(head1, head2, len1 - len2);
        } else {
            return intersectPoint(head2, head1, len2 - len1);
        }
    }

    /**
     * Helper method to find the intersection point when the lengths of the two lists are known.
     *
     * @param head1 The head of the longer linked list.
     * @param head2 The head of the shorter linked list.
     * @param d The difference in lengths between the two lists.
     * @return The data of the intersection node, or -1 if no intersection is found.
     */
    private static int intersectPoint(Node head1, Node head2, int d) {
        Node current1 = head1;  // Initialize pointer for the longer list
        Node current2 = head2;  // Initialize pointer for the shorter list

        // Advance the pointer for the longer list by 'd' nodes
        while (d-- > 0) {
            current1 = current1.next;
        }

        // Move both pointers until they meet
        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    /**
     * Helper method to calculate the length of a linked list.
     *
     * @param head The head of the linked list.
     * @return The length of the linked list.
     */
    private static int getLength(Node head) {
        Node current = head;  // Initialize pointer
        int len = 0;
        while (current != null) {
            current = current.next;  // Move to the next node
            len++;
        }
        return len;
    }
}
