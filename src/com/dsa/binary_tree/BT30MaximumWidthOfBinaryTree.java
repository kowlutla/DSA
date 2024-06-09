/**
 * 	Given the root of a binary tree, return the maximum width of the given tree.
	
	The maximum width of a tree is the maximum width among all levels.
	The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
	It is guaranteed that the answer will in the range of a 32-bit signed integer.
	
	Example 1:
	Input: root = [1,3,2,5,3,null,9]
	Output: 4
	Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

	Example 2:
	Input: root = [1,3,2,5,null,null,9,6,null,7]
	Output: 7
	Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

	Example 3:
	Input: root = [1,3,2,5]
	Output: 2
	Explanation: The maximum width exists in the second level with length 2 (3,2).
	 
 */
package com.dsa.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BT30MaximumWidthOfBinaryTree {

    // Pair class to store the node and its index
    class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    /**
     * Computes the maximum width of a binary tree.
     *
     * The width of a binary tree is the maximum number of nodes between the leftmost and rightmost nodes at any level.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - due to the space required for the queue.
     *
     * @param root The root node of the binary tree.
     * @return The maximum width of the tree.
     */
    public int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0; // If the tree is empty, return 0
        }

        int ans = 0; // Initialize the maximum width to 0
        Queue<Pair> q = new LinkedList<>(); // Create a queue to perform level-order traversal
        q.add(new Pair(root, 0)); // Add the root node to the queue with index 0

        while (!q.isEmpty()) {
            int size = q.size(); // Get the number of nodes at the current level
            int first = 0; // Index of the first node at the current level
            int last = 0; // Index of the last node at the current level
            int mmin = q.peek().index; // Minimum index at the current level to handle integer overflow

            // Process all nodes at the current level
            for (int i = 1; i <= size; i++) {
                Pair p = q.poll(); // Remove the front node from the queue
                Node temp = p.node; // Get the node
                int currentIndex = p.index - mmin; // Calculate the adjusted index

                // Update first and last indices
                if (i == 1) {
                    first = currentIndex;
                }
                if (i == size) {
                    last = currentIndex;
                }

                // Add the left child of the node to the queue with the appropriate index
                if (temp.left != null) {
                    q.add(new Pair(temp.left, currentIndex * 2 + 1));
                }

                // Add the right child of the node to the queue with the appropriate index
                if (temp.right != null) {
                    q.add(new Pair(temp.right, currentIndex * 2 + 2));
                }
            }

            // Update the maximum width
            ans = Math.max(last - first + 1, ans);
        }
        return ans; // Return the maximum width
    }
}
