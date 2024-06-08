/**
 * 	Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.
	
	Example 1:
	
	Input:
	         5
	       /   \
	      1     1
	     /       \
	    2         2
	Output: 
	True
	Explanation: 
	Tree is mirror image of itself i.e. tree is symmetric
	Example 2:
	
	Input:
	         5
	       /   \
	      10     10
	     /  \     \
	    20  20     30
	Output: 
	False
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT25SymmetricTree {

    /**
     * Determines if a binary tree is symmetric around its center.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(H) - where H is the height of the binary tree (for the recursive call stack).
     *
     * @param root The root node of the binary tree.
     * @return true if the binary tree is symmetric, false otherwise.
     */
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * Helper method to check symmetry between two subtrees.
     * 
     * @param node1 The root node of the first subtree.
     * @param node2 The root node of the second subtree.
     * @return true if the subtrees are mirror images of each other, false otherwise.
     */
    private static boolean isSymmetric(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2; // Both nodes should be null to be symmetric
        }

        // Check if the current nodes have the same data and their respective subtrees are symmetric
        return node1.data == node2.data && 
               isSymmetric(node1.left, node2.right) && 
               isSymmetric(node1.right, node2.left);
    }
}

