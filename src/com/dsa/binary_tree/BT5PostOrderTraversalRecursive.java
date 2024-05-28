/**
 * 	Given a binary tree, find the Postorder Traversal of it.
	For Example, the postorder traversal of the following tree is:
	5 10 39 1
	
	        1
	     /     \
	   10     39
	  /
	5
	
	
	Example 1:
	
	Input:
	        19
	     /     \
	    10      8
	  /    \
	 11    13
	Output: 11 13 10 8 19
	Example 2:
	
	Input:
	          11
	         /
	       15
	      /
	     7
	Output: 7 15 11
 */
package com.dsa.binary_tree;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.ArrayList;

public class BT5PostOrderTraversalRecursive {

    /**
     * Performs a post-order traversal of the binary tree and returns a list of node values.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList of integers representing the node values in post-order traversal.
     */
    public static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> postOrderNodes = new ArrayList<>();
        postOrder(root, postOrderNodes); // Initiates the recursive post-order traversal
        return postOrderNodes;
    }

    /**
     * Helper method to recursively perform a post-order traversal of the binary tree.
     *
     * @param root           The current node being visited.
     * @param postOrderNodes The list to store the node values in post-order traversal.
     */
    private static void postOrder(Node root, ArrayList<Integer> postOrderNodes) {

        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Recursively traverse the left subtree
        postOrder(root.left, postOrderNodes);

        // Recursively traverse the right subtree
        postOrder(root.right, postOrderNodes);

        // Add the current node's value to the post-order list
        postOrderNodes.add(root.data);
    }
}
