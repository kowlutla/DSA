/**
 * 	Given a binary tree, find its preorder traversal.
	
	Example 1:
	Input:
	        1      
	      /          
	    4    
	  /    \   
	4       2
	Output: 1 4 4 2 

	Example 2:
	Input:
	       6
	     /   \
	    3     2
	     \   / 
	      1 2
	Output: 6 3 1 2 2 

 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BT3PreorderTraversalRecursive {

    /**
     * Performs a pre-order traversal of the binary tree and returns a list of node values.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList of integers representing the node values in pre-order traversal.
     */
    public static List<Integer> preorder(Node root) {
        ArrayList<Integer> preOrderNodes = new ArrayList<>();
        preOrder(root, preOrderNodes); // Initiates the recursive pre-order traversal
        return preOrderNodes;
    }

    /**
     * Helper method to recursively perform a pre-order traversal of the binary tree.
     *
     * @param root          The current node being visited.
     * @param preOrderNodes The list to store the node values in pre-order traversal.
     */
    private static void preOrder(Node root, ArrayList<Integer> preOrderNodes) {

        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Add the current node's value to the pre-order list
        preOrderNodes.add(root.data);

        // Recursively traverse the left subtree
        preOrder(root.left, preOrderNodes);

        // Recursively traverse the right subtree
        preOrder(root.right, preOrderNodes);
    }
}
