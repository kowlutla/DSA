/**
 * 	Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

	Example 1:
	Input: 
	N = 7
	Link List:
	17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
	Output: 8 2 4 6 17 15 9
	
	Explaination: 8,2,4,6 are the even numbers 
	so they appear first and 17,15,9 are odd 
	numbers that appear later.
	
	Example 2:
	Input:
	N = 4
	Link List:
	1 -> 3 -> 5 -> 7
	Output: 1 3 5 7
	Explaination: There is no even number. 
	So no need for modification.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L17SegregateEvenOddNodes {

    /**
     * Segregates even and odd nodes into two separate lists and then combines them.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(N), due to the creation of new nodes.
     *
     * @param head The head node of the linked list.
     * @return The head of the modified list with all even nodes followed by odd nodes.
     */
    public static Node divide1(Node head) {
        Node even = new Node(0); // Dummy node for the even list
        Node odd = new Node(0);  // Dummy node for the odd list

        Node current1 = even;
        Node current2 = odd;
        Node current = head;

        // Traverse the original list and divide nodes into even and odd lists
        while (current != null) {
            if (current.data % 2 == 0) {
                Node newNode = new Node(current.data); // Create a new node for even list
                current1.next = newNode;
                current1 = current1.next;
            } else {
                Node newNode = new Node(current.data); // Create a new node for odd list
                current2.next = newNode;
                current2 = current2.next;
            }
            current = current.next;
        }

        current1.next = odd.next; // Link the end of even list to the start of odd list
        return even.next; // Return the head of the new list
    }

    /**
     * Segregates even and odd nodes in place within the original list.
     *
     * Time Complexity: O(N), where N is the number of nodes in the list.
     * Space Complexity: O(1), as no extra space is used other than pointers.
     *
     * @param N    The number of nodes in the linked list.
     * @param head The head node of the linked list.
     * @return The head of the modified list with all even nodes followed by odd nodes.
     */
    public static Node divide2(int N, Node head) {
        Node even = new Node(-1); // Dummy node for the even list
        Node odd = new Node(-1);  // Dummy node for the odd list

        Node lastEven = even;
        Node lastOdd = odd;

        Node current = head;

        // Traverse the original list and rearrange nodes in place
        while (current != null) {
            if (current.data % 2 == 0) {
                lastEven.next = current; // Attach to the even list
                lastEven = current;
            } else {
                lastOdd.next = current; // Attach to the odd list
                lastOdd = current;
            }
            current = current.next;
        }

        lastOdd.next = null; // End the odd list
        lastEven.next = odd.next; // Link the end of even list to the start of odd list
        head = even.next; // Update head to the start of the even list
        return head; // Return the head of the new list
    }
}
