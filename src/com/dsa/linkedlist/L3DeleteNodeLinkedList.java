/**
 * 	There is a singly-linked list head and we want to delete a node node in it.
	
	You are given the node to be deleted node. You will not be given access to the first node of head.
	
	All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
	
	Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
	
	The value of the given node should not exist in the linked list.
	The number of nodes in the linked list should decrease by one.
	All the values before node should be in the same order.
	All the values after node should be in the same order.
	Custom testing:
	
	For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
	We will build the linked list and pass the node to your function.
	The output will be the entire list after calling your function.
	 
	
	Example 1:
	Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
	Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

	Example 2:
	Input: head = [4,5,1,9], node = 1
	Output: [4,5,9]
	Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 */
package com.dsa.linkedlist;

/**
 * @author KowlutlaSwamy
 *
 */
public class L3DeleteNodeLinkedList {

    /**
     * Deletes the given node from the linked list. Note that we are given
     * only the node to be deleted, not the head of the list.
     * 
     * @param node The node to be deleted.
     */
    public void deleteNode(Node node) {
        // Copy the data from the next node to the current node
        node.data = node.next.data;
        // Bypass the next node
        node.next = node.next.next;
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
        // Example 1
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(9);

        System.out.print("Original List: ");
        printList(head1);

        Node nodeToDelete1 = head1.next; // Node with value 5
        L3DeleteNodeLinkedList solution1 = new L3DeleteNodeLinkedList();
        solution1.deleteNode(nodeToDelete1);

        System.out.print("Modified List after deleting node 5: ");
        printList(head1);

        // Example 2
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(9);

        System.out.print("Original List: ");
        printList(head2);

        Node nodeToDelete2 = head2.next.next; // Node with value 1
        L3DeleteNodeLinkedList solution2 = new L3DeleteNodeLinkedList();
        solution2.deleteNode(nodeToDelete2);

        System.out.print("Modified List after deleting node 1: ");
        printList(head2);
    }
}