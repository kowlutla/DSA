/**
 * 	Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
	
	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[9,20],[15,7]]

	Example 2:
	Input: root = [1]
	Output: [[1]]

	Example 3:
	Input: root = []
	Output: []
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT7LevelOrderTraversal2 {

    /**
     * Performs a level-order traversal of the binary tree and returns a list of node values for each level.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(n), where n is the number of nodes in the tree. This accounts for the space used by the queue and the resulting list of lists.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists containing node values for each level of the tree.
     */
    public List<List<Integer>> levelOrder(Node root) {
        // Initialize a list to hold the levels of nodes
        List<List<Integer>> levelOrderNodes = new ArrayList<>();
        // Check if the tree is empty
        if (root == null) {
            return levelOrderNodes;
        }
        // Create a queue to perform level-order traversal
        Queue<Node> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);
        // Continue traversal until the queue is empty
        while (!q.isEmpty()) {
            // Get the number of nodes in the current level
            int size = q.size();
            // Create a list to hold the node values of the current level
            List<Integer> currentLevel = new ArrayList<>();
            // Traverse all nodes in the current level
            for (int i = 0; i < size; i++) {
                // Remove the first node from the queue
                Node current = q.poll();
                // Add the node value to the current level list
                currentLevel.add(current.data);
                // Add the left child of the current node to the queue if it exists
                if (current.left != null) {
                    q.add(current.left);
                }
                // Add the right child of the current node to the queue if it exists
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            // Add the current level list to the list of levels
            levelOrderNodes.add(currentLevel);
        }
        // Return the list of lists containing node values for each level
        return levelOrderNodes;
    }
}
