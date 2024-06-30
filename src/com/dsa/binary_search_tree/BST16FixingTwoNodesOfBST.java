/**
 * 	You are given the root of a binary search tree(BST), where exactly two nodes were swapped by mistake. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
	Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.
	 
	Examples :
	Input:
	       10
	     /    \
	    5      8
	   / \
	  2   20
	Output: 1
	Explanation:
	 
	 
	
	Input:
	         11
	       /    \
	      3      17
	       \    /
	        4  10
	Output: 1 
	Explanation: By swapping nodes 11 and 10, the BST can be fixed.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST16FixingTwoNodesOfBST {

    private Node first;
    private Node second;
    private Node middle;
    private Node prev;

    /**
     * Method to correct a BST where two nodes are swapped by mistake.
     * @param root the root of the BST
     * @return the root of the corrected BST
     */
    public Node correctBST(Node root) {
        first = second = middle = prev = null; // Initialize pointers
        inOrder(root); // Perform in-order traversal to find the swapped nodes

        // Swap the data of the first and second/middle nodes to correct the BST
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        return root; // Return the root of the corrected BST
    }

    /**
     * Helper method to perform in-order traversal and identify the swapped nodes.
     * @param root the current node
     */
    private void inOrder(Node root) {
        if (root == null) {
            return; // Base case: return if the current node is null
        }

        inOrder(root.left); // Recursively traverse the left subtree

        // If a previous node exists and its data is greater than the current node's data
        if (prev != null && prev.data > root.data) {
            if (first == null) { // First occurrence of a swapped node
                first = prev;
                middle = root;
            } else { // Second occurrence of a swapped node
                second = root;
            }
        }

        prev = root; // Update the previous node to the current node
        inOrder(root.right); // Recursively traverse the right subtree
    }
}
