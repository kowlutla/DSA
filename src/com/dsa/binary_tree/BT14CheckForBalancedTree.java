/**
 * 	Given a binary tree, find if it is height balanced or not. 
	A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 
	
	A height balanced tree
	        1
	     /     \
	   10      39
	  /
	5
	
	An unbalanced tree
	        1
	     /    
	   10   
	  /
	5
	
	Example 1:
	
	Input:
	      1
	    /
	   2
	    \
	     3 
	Output: 0
	Explanation: The max difference in height
	of left subtree and right subtree is 2,
	which is greater than 1. Hence unbalanced
	Example 2:
	
	Input:
	       10
	     /   \
	    20   30 
	  /   \
	 40   60
	Output: 1
	Explanation: The max difference in height
	of left subtree and right subtree is 1.
	Hence balanced. 
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT14CheckForBalancedTree {

    /**
     * Checks if the binary tree is balanced using a recursive approach.
     *
     * Time Complexity: O(n^2) in the worst case, where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param root The root node of the binary tree.
     * @return True if the binary tree is balanced, false otherwise.
     */
    public static boolean isBalanced1(Node root) {
        // Base case: If the tree is empty, it is balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);

        // Check if the current node is balanced and recursively check for the left and right subtrees
        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced1(root.left) && isBalanced1(root.right)) {
            return true;
        }

        return false; // If any condition fails, the tree is not balanced
    }

    /**
     * Calculates the height of a node in the binary tree.
     *
     * @param node The node whose height is to be calculated.
     * @return The height of the node.
     */
    public static int height1(Node node) {
        // Base case: If the node is null, the height is 0
        if (node == null) {
            return 0;
        }

        // Recursive case: Height is 1 (for the current node) plus the maximum height of the left and right subtrees
        return 1 + Math.max(height1(node.left), height1(node.right));
    }

    /**
     * Checks if the binary tree is balanced using an optimized approach.
     *
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param root The root node of the binary tree.
     * @return True if the binary tree is balanced, false otherwise.
     */
    public static boolean isBalanced2(Node root) {
        // If the height function returns -1, the tree is not balanced
        return height2(root) != -1;
    }

    /**
     * Calculates the height of a node in the binary tree and checks for balance.
     *
     * @param node The node whose height is to be calculated.
     * @return The height of the node if the tree is balanced, otherwise -1.
     */
    public static int height2(Node node) {
        // Base case: If the node is null, the height is 0
        if (node == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height2(node.left);
        int rightHeight = height2(node.right);

        // Check if the left or right subtree is not balanced
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the difference in height is greater than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
