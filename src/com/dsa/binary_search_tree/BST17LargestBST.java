/**
 * 	Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
	Note: Here Size is equal to the number of nodes in the subtree.
	
	Example 1:
	Input:
	        1
	      /   \
	     4     4
	   /   \
	  6     8
	Output: 1
	Explanation: There's no sub-tree with size
	greater than 1 which forms a BST. All the
	leaf Nodes are the BSTs with size equal
	to 1.

	Example 2:
	Input: 6 6 3 N 2 9 3 N 8 8 2
	            6
	        /       \
	       6         3
	        \      /   \
	         2    9     3
	          \  /  \
	          8 8    2 
	Output: 2
	Explanation: The following sub-tree is a
	BST of size 2: 
	       2
	    /    \ 
	   N      8
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST17LargestBST {

    private static class NodeValue {
        int min;
        int max;
        int size;

        public NodeValue(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    /**
     * Method to find the size of the largest BST in a binary tree.
     * @param root the root of the binary tree
     * @return the size of the largest BST
     */
    public static int largestBst(Node root) {
        return largest(root).size;
    }

    /**
     * Helper method to find the largest BST in a binary tree.
     * @param root the current node
     * @return a NodeValue object containing min, max, and size of the largest BST
     */
    private static NodeValue largest(Node root) {
        if (root == null) {
            // Base case: return default NodeValue for null nodes
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largest(root.left); // Recursively find the largest BST in the left subtree
        NodeValue right = largest(root.right); // Recursively find the largest BST in the right subtree

        // Check if the current node is part of a valid BST
        if (left.max < root.data && right.min > root.data) {
            // If valid, update the min, max, and size
            return new NodeValue(
                Math.min(root.data, left.min), // Update min value
                Math.max(root.data, right.max), // Update max value
                left.size + right.size + 1 // Update size of the largest BST
            );
        }

        // If not a valid BST, return the max size found in either the left or right subtree
        return new NodeValue(
            Integer.MIN_VALUE, // Invalid min value
            Integer.MAX_VALUE, // Invalid max value
            Math.max(left.size, right.size) // Max size of left or right subtree
        );
    }
}
