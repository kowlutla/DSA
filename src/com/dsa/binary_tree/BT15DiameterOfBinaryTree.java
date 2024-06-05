/**
	The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes). 
	
	Example 1:
	Input:
	       1
	     /  \
	    2    3
	Output: 3

	Example 2:
	Input:
	         10
	        /   \
	      20    30
	    /   \ 
	   40   60
	Output: 4
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT15DiameterOfBinaryTree {

    /**
     * Calculates the diameter of the binary tree using a less efficient method.
     *
     * Time Complexity: O(n^2), where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param root The root node of the binary tree.
     * @return The diameter of the binary tree.
     */
    public int diameter1(Node root) {
        // Base case: If the tree is empty, the diameter is 0
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        // Calculate the diameter passing through the current node
        int current = 1 + leftHeight + rightHeight;

        // Calculate the diameter of the left and right subtrees
        int leftDiameter = diameter1(root.left);
        int rightDiameter = diameter1(root.right);

        // Return the maximum of the diameters
        return Math.max(leftDiameter, Math.max(current, rightDiameter));
    }

    /**
     * Calculates the height of a node in the binary tree.
     *
     * @param root The node whose height is to be calculated.
     * @return The height of the node.
     */
    private int height1(Node root) {
        // Base case: If the node is null, the height is 0
        if (root == null) {
            return 0;
        }
        // Recursive case: Height is 1 (for the current node) plus the maximum height of the left and right subtrees
        return 1 + Math.max(height1(root.left), height1(root.right));
    }

    /**
     * Calculates the diameter of the binary tree using an optimized method.
     *
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param root The root node of the binary tree.
     * @return The diameter of the binary tree.
     */
    public int diameter2(Node root) {
        // Initialize an array to store the diameter
        int[] diameter = new int[1];
        diameter[0] = 0;
        // Call the height function to traverse the tree and calculate diameter
        height2(root, diameter);
        // Return the calculated diameter
        return diameter[0];
    }

    /**
     * Calculates the height of a node in the binary tree and updates the diameter.
     *
     * @param node The node whose height is to be calculated.
     * @param diameter The array storing the diameter of the binary tree.
     * @return The height of the node.
     */
    private int height2(Node node, int[] diameter) {
        // Base case: If the node is null, return 0 indicating the height of an empty tree
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int lh = height2(node.left, diameter);
        int rh = height2(node.right, diameter);

        // Update the diameter with the maximum of current diameter or sum of left and right heights
        diameter[0] = Math.max(diameter[0], 1 + lh + rh);

        // Return the height of the current node's subtree
        return 1 + Math.max(lh, rh);
    }
}
