/**
 * 	You are given the root of a complete binary tree. Your task is to find the count of nodes.
	A complete binary tree is a binary tree whose, all levels except the last one are completely filled, the last level may or may not be completely filled and Nodes in the last level are as left as possible.
	Design an algorithm that runs better than O(n).
	
	Example:
	Input: 
	root = [1,2,3,4,5,6]
	Output: 
	6
	
	Explanation: 
	There are a total of 6 nodes in the given tree.
	Your Task:
	Complete the function int cnt_nodes(Node *root), which takes the pointer of the root of the given Binary tree and returns the count of its number of nodes.
	Expected Time Complexity: O((LogN)2).
	Expected Auxiliary Space: O(Log N).
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT35CountCompleteTreeNodes {

    /**
     * Counts the number of nodes in a complete binary tree.
     *
     * @param root The root of the binary tree.
     * @return The total number of nodes in the tree.
     * 
     * Time Complexity: O(log^2 N)
     * The height calculation takes O(log N) time and this is done for each level of the tree, resulting in O(log^2 N) time.
     * 
     * Space Complexity: O(log N)
     * The recursion stack can go as deep as the height of the tree, which is log N for a complete binary tree.
     */
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        // Get the height of the leftmost path.
        int leftHeight = getLeftHeight(root);

        // Get the height of the rightmost path.
        int rightHeight = getRightHeight(root);

        // If the heights are the same, the tree is a perfect binary tree.
        if (leftHeight == rightHeight) {
            // Number of nodes in a perfect binary tree of height h is 2^h - 1.
            return (int) Math.pow(2, leftHeight) - 1;
        } else {
            // Recursively count the nodes in the left and right subtrees and add 1 for the root.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * Calculates the height of the leftmost path in the tree.
     *
     * @param node The root of the tree.
     * @return The height of the leftmost path.
     */
    private static int getLeftHeight(Node node) {
        Node current = node;
        int height = 0;

        // Traverse left until a null node is encountered.
        while (current != null) {
            current = current.left;
            height++;
        }
        return height;
    }

    /**
     * Calculates the height of the rightmost path in the tree.
     *
     * @param node The root of the tree.
     * @return The height of the rightmost path.
     */
    private static int getRightHeight(Node node) {
        Node current = node;
        int height = 0;

        // Traverse right until a null node is encountered.
        while (current != null) {
            height++;
            current = current.right;
        }
        return height;
    }
}
