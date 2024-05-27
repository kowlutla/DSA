/**
 * 	You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers, where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b (arb is pointer to random node).
	Construct a copy of the given list. The copy should consist of exactly N new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

	For example, if there are two nodes X and Y in the original list, where X.arb --> Y, then for the corresponding two nodes x and y in the copied list, x.arb --> y.
	Return the head of the copied linked list.
	
	Example 1:
	Input:
	N = 4, M = 2
	value = {1,2,3,4}
	pairs = {{1,2},{2,4}}
	Output: 1
	Explanation: In this test case, there
	are 4 nodes in linked list.  Among these
	4 nodes,  2 nodes have arbitrary pointer
	set, rest two nodes have arbitrary pointer
	as NULL. Second line tells us the value
	of four nodes. The third line gives the
	information about arbitrary pointers.
	The first node arbitrary pointer is set to
	node 2.  The second node arbitrary pointer
	is set to node 4.

	Example 2:
	Input:
	N = 4, M = 2
	value[] = {1,3,5,9}
	pairs[] = {{1,1},{3,4}}
	Output: 1
	Explanation: In the given testcase ,
	applying the method as stated in the
	above example, the output will be 1.
 */
package com.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KowlutlaSwamy
 *
 */
public class L33CloneLinkedListWithRandomPointer {

    /**
     * Clones a linked list with next and random (arb) pointers using a HashMap.
     *
     * @param head the head of the original linked list
     * @return the head of the cloned linked list
     * 
     * Time complexity: O(n) where n is the number of nodes
     * Space complexity: O(n) due to the use of the HashMap
     */
    public static Node copyList1(Node head) {
        // Create a map to store the mapping from original nodes to their clones
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        
        // Create new nodes and put them in the map
        while (current != null) {
            Node newNode = new Node(current.data);
            map.put(current, newNode);
            current = current.next;
        }

        // Set next and random (arb) pointers for the cloned nodes
        current = head;
        while (current != null) {
            Node copyNode = map.get(current);
            copyNode.next = map.get(current.next);
            copyNode.arb = map.get(current.arb);
            current = current.next;
        }

        // Return the head of the cloned list
        return map.get(head);
    }

    /**
     * Clones a linked list with next and random (arb) pointers by interleaving the original list with cloned nodes.
     *
     * @param head the head of the original linked list
     * @return the head of the cloned linked list
     * 
     * Time complexity: O(n) where n is the number of nodes
     * Space complexity: O(1)
     */
    public static Node copyList2(Node head) {
        // Insert cloned nodes in between the original nodes
        insertNodesInBetween(head);
        // Connect the random (arb) pointers of the cloned nodes
        connectRandomPointers(head);
        // Separate the cloned nodes to form the cloned list
        Node clonedHead = getDeepCopyList(head);
        return clonedHead;
    }

    /**
     * Inserts cloned nodes in between the original nodes.
     *
     * @param head the head of the linked list after inserting copy nodes
     */
    private static void insertNodesInBetween(Node head) {
        Node current = head;
        
        // Traverse the original list and insert cloned nodes after each original node
        while (current != null) {
            Node copyNode = new Node(current.data);
            copyNode.next = current.next; // Set the next of cloned node to the next of current node
            current.next = copyNode; // Link current node to its cloned node
            current = current.next.next; // Move to the next original node
        }
    }

    /**
     * Connects the random (arb) pointers of the cloned nodes.
     *
     * @param head the head of the random links connected linked list
     */
    private static void connectRandomPointers(Node head) {
        Node current = head;

        // Traverse the original list and set the random pointers of the cloned nodes
        while (current != null) {
            Node copyNode = current.next;
            if (current.arb != null) {
                copyNode.arb = current.arb.next; // Set random pointer of cloned node
            } else {
                copyNode.arb = null; // If original node's random pointer is null, cloned node's random pointer is also null
            }
            current = current.next.next; // Move to the next original node
        }
    }

    /**
     * Extracts the cloned nodes to form the deep copy list.
     *
     * @param head the head of the original linked list
     * @return the head of the deep copy list
     */
    private static Node getDeepCopyList(Node head) {
        Node cloneHead = new Node(-1); // Dummy node to form the cloned list
        Node cloneLast = cloneHead; // Pointer to the last node in the cloned list
        Node current = head;
        
        // Separate the cloned list from the original list
        while (current != null) {
            cloneLast.next = current.next; // Append cloned node to the cloned list
            cloneLast = current.next; // Move to the next cloned node

            current.next = current.next.next; // Restore the original list
            current = current.next; // Move to the next original node
        }

        return cloneHead.next; // Return the head of the cloned list (skipping dummy node)
    }

    private static class Node {
        int data;
        Node next;
        Node arb;

        Node(int d) {
            data = d;
            next = arb = null;
        }
    }
}
