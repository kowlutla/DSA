/**
 * 	Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes at any level.
	For example, the maximum width of the following tree is 4 as there are 4 nodes at the 3rd level.
	
	          1
	       /     \
	     2        3
	   /    \    /    \
	  4    5   6    7
	    \
	      8
	
	Example 1:
	
	Input:
	       1
	     /    \
	    2      3
	Output: 2
	On the first level there is only
	one node 1
	On the second level there are
	two nodes 2, 3 clearly it is the 
	maximum number of nodes at any level
	
	Example 2:
	
	Input:
	        10
	      /     \
	    20      30
	   /    \
	  40    60
	Output: 2
	There is one node on level 1(10)
	There is two node on level 2(20, 30)
	There is two node on level 3(40, 60)
	Hence the answer is 2

 */
package com.dsa.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BT29MaximumWidthOfTree {

    /**
     * Computes the maximum width of a binary tree.
     *
     * The width of a binary tree is the maximum number of nodes at any level in the tree.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - due to the space required for the queue.
     *
     * @param root The root node of the binary tree.
     * @return The maximum width of the tree.
     */
    public static int getMaxWidth(Node root) {
        int width = 0; // Initialize the maximum width to 0

        if (root == null) {
            return width; // If the tree is empty, return 0
        }

        Queue<Node> q = new LinkedList<>(); // Create a queue to perform level-order traversal
        q.add(root); // Add the root node to the queue

        while (!q.isEmpty()) {
            int size = q.size(); // Get the number of nodes at the current level
            width = Math.max(width, size); // Update the maximum width

            // Process all nodes at the current level
            for (int i = 1; i <= size; i++) {
                Node temp = q.poll(); // Remove the front node from the queue

                // Add the left child of the node to the queue if it exists
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add the right child of the node to the queue if it exists
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return width; // Return the maximum width
    }
}
