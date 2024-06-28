/**
 * 	Given the root of a binary tree. Check whether it is a BST or not.
	Note: We are considering that BSTs can not contain duplicate Nodes.
	A BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Examples:
	
	Input:
	   2
	 /    \
	1      3
	        \
	         5
	Output: true 
	Explanation: 
	The left subtree of every node contains smaller keys and right subtree of every node contains greater. Hence, the tree is a BST.
	
	Input:
	  2
	   \
	    7
	     \
	      6
	       \
	        9
	Output: false 
	Explanation: 
	Since the node with value 7 has right subtree nodes with keys less than 7, this is not a BST. 
	
	Input:
	   10
	 /    \
	5      20
	      /   \
	     9     25
	Output: false
	Explanation: The node is present in the right subtree of 10, but it is smaller than 10.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST10CheckForBST {

    /**
     * Checks if a binary tree is a BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the root node of the binary tree
     * @return true if the binary tree is a BST, false otherwise
     */
    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Helper method to validate the BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the current node
     * @param min the minimum allowed value for the current node
     * @param max the maximum allowed value for the current node
     * @return true if the subtree rooted at the current node is a BST, false otherwise
     */
    private static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true; // Return true if the node is null (base case)
        }

        // If the current node's value is out of the valid range, return false
        if (root.data <= min || root.data >= max) {
            return false;
        }

        // Recursively check the left and right subtrees with updated ranges
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
