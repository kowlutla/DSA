/**
 * 	Given a singly linked list and an integer x.Delete xth node from the singly linked list.

	Example 1:
	Input: 1 -> 3 -> 4 
	       x = 3
	Output: 1 -> 3
	Explanation:
	After deleting the node at 3rd
	position (1-base indexing), the
	linked list is as 1 -> 3. 

	Example 2:
	Input: 1 -> 5 -> 2 -> 9 
	x = 2
	Output: 1 -> 2 -> 9
	Explanation: 
	After deleting the node at 2nd
	position (1-based indexing), the
	linked list is as 1 -> 2 -> 9.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L3DeleteNthNode {

    /**
     * Deletes the x-th node from the linked list.
     * 
     * @param head The head node of the linked list.
     * @param x The position (1-based index) of the node to delete.
     * @return The head node of the modified linked list.
     */
    public static Node deleteNode(Node head, int x) {
        // If the node to be deleted is the head node
        if (x == 1) {
            return head.next;
        }

        Node current = head;
        Node prev = null;

        int count = 1;
        // Traverse to the x-th node
        while (count < x) {
            prev = current;
            current = current.next;
            count++;
        }

        // Bypass the x-th node
        if (current != null) {
            prev.next = current.next;
        }

        return head;
    }

    /**
     * Prints the elements of the linked list starting from the given head node.
     * 
     * @param head The head node of the linked list.
     */
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Linked list: 1 -> 3 -> 4, x = 3
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        int x1 = 3;

        System.out.println("Original List 1:");
        printList(head1);
        head1 = deleteNode(head1, x1);
        System.out.println("Modified List 1 after deleting node at position " + x1 + ":");
        printList(head1);

        // Test Case 2: Linked list: 1 -> 5 -> 2 -> 9, x = 2
        Node head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(9);
        int x2 = 2;

        System.out.println("Original List 2:");
        printList(head2);
        head2 = deleteNode(head2, x2);
        System.out.println("Modified List 2 after deleting node at position " + x2 + ":");
        printList(head2);

        // Additional test case can be added similarly
    }
}