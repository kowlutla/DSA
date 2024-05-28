/**
 * 	Given a Binary Tree, find the In-Order Traversal of it.
	
	Example 1:
	
	Input:
	       1
	     /  \
	    3    2
	Output: 3 1 2
	
	Example 2:
	
	Input:
	        10
	     /      \ 
	    20       30 
	  /    \    /
	 40    60  50
	Output: 40 20 60 10 50 30

 */
package com.dsa.binary_tree;

import java.util.ArrayList;

public class BT4InOrderTraversalRecursive {

    /**
     * Performs an in-order traversal of the binary tree and returns a list of node values.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList of integers representing the node values in in-order traversal.
     */
    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inOrderNodes = new ArrayList<>();
        inOrder(root, inOrderNodes); // Initiates the recursive in-order traversal
        return inOrderNodes;
    }

    /**
     * Helper method to recursively perform an in-order traversal of the binary tree.
     *
     * @param root          The current node being visited.
     * @param inOrderNodes  The list to store the node values in in-order traversal.
     */
    private static void inOrder(Node root, ArrayList<Integer> inOrderNodes) {

        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Recursively traverse the left subtree
        inOrder(root.left, inOrderNodes);

        // Add the current node's value to the in-order list
        inOrderNodes.add(root.data);

        // Recursively traverse the right subtree
        inOrder(root.right, inOrderNodes);
    }
}
