/**
 * 	Given a binary tree, find its height.
	
	Example 1:
	Input:
	     1
	    /  \
	   2    3
	Output: 2

	Example 2:
	Input:
	  2
	   \
	    1
	   /
	 3
	Output: 3   
 */
package com.dsa.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class BT13HeightOfBinaryTree {

    /**
     * Calculates the height of the binary tree using a recursive approach.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param node The root node of the binary tree.
     * @return The height of the binary tree.
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
     * Calculates the height of the binary tree using an iterative approach with a queue.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(n), where n is the number of nodes in the binary tree (due to the queue).
     *
     * @param node The root node of the binary tree.
     * @return The height of the binary tree.
     */
    public static int height2(Node node) {
        // Base case: If the node is null, the height is 0
        if (node == null) {
            return 0;
        }

        // Initialize a queue to perform level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int height = 0;

        // Process each level of the tree
        while (!q.isEmpty()) {
            height++; // Increment height for each level
            int size = q.size(); // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 1; i <= size; i++) {
                Node temp = q.poll(); // Remove node from queue

                // Add left child to queue if it exists
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add right child to queue if it exists
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return height; // Return the calculated height
    }
}
