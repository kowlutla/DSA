/**
 *  Create a link list of size N according to the given input literals. 
   	Each integer input is accompanied by an indicator which can either be 0 or 1. 
   	If it is 0, insert the integer in the beginning of the link list. If it is 1, 
   	insert the integer at the end of the link list. 
	Hint: When inserting at the end, make sure that you handle NULL explicitly.
	
	Example 1:
	
	Input:
	LinkedList: 9->0->5->1->6->1->2->0->5->0
	Output: 5 2 9 5 6
	Explanation:
	Length of Link List = N = 5
	9 0 indicated that 9 should be
	inserted in the beginning. Modified
	Link List = 9.
	5 1 indicated that 5 should be
	inserted in the end. Modified Link
	List = 9,5.
	6 1 indicated that 6 should be
	inserted in the end. Modified Link
	List = 9,5,6.
	2 0 indicated that 2 should be
	inserted in the beginning. Modified
	Link List = 2,9,5,6.
	5 0 indicated that 5 should be
	inserted in the beginning. Modified
	Link List = 5,2,9,5,6. 
	Final linked list = 5, 2, 9, 5, 6.
	
	Example 2:
	
	Input:
	LinkedList: 5->1->6->1->9->1
	Output: 5 6 9
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L2LinkedListInsertion {

    /**
     * Inserts a new node at the beginning of the linked list.
     * 
     * @param head The head node of the linked list.
     * @param x The value to be inserted.
     * @return The new head of the linked list.
     */
    public Node insertAtBeginning(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head; // New node points to the current head
        head = newNode; // Head is updated to the new node
        return head; // Return the new head
    }

    /**
     * Inserts a new node at the end of the linked list.
     * 
     * @param head The head node of the linked list.
     * @param x The value to be inserted.
     * @return The head of the linked list.
     */
    public Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode; // If the list is empty, the new node is the head
            return head;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }
        current.next = newNode; // Link the last node to the new node
        return head;
    }

    /**
     * Constructs a linked list from the given array of values and indicators.
     * 
     * @param arr The input array containing values and indicators.
     * @return The head node of the constructed linked list.
     */
    public Node constructLinkedList(int[][] arr) {
        Node head = null;
        for (int[] pair : arr) {
            int value = pair[0];
            int indicator = pair[1];
            if (indicator == 0) {
                head = insertAtBeginning(head, value);
            } else if (indicator == 1) {
                head = insertAtEnd(head, value);
            }
        }
        return head;
    }

    /**
     * Prints the elements of the linked list.
     * 
     * @param head The head node of the linked list.
     */
    public void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        L2LinkedListInsertion listInsertion = new L2LinkedListInsertion();

        // Example 1
        int[][] input1 = {
            {9, 0},
            {5, 1},
            {6, 1},
            {2, 0},
            {5, 0}
        };
        Node head1 = listInsertion.constructLinkedList(input1);
        System.out.print("Final linked list for example 1: ");
        listInsertion.printLinkedList(head1);

        // Example 2
        int[][] input2 = {
            {5, 1},
            {6, 1},
            {9, 1}
        };
        Node head2 = listInsertion.constructLinkedList(input2);
        System.out.print("Final linked list for example 2: ");
        listInsertion.printLinkedList(head2);
    }
}