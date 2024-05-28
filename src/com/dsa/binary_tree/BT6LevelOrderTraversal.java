/**
 * 	Given a root of a binary tree with n nodes, find its level order traversal.
	Level order traversal of a tree is breadth-first traversal for the tree.
	
	Example 1:
	Input:
	    1
	  /   \ 
	 3     2
	Output:
	1 3 2
	
	Example 2:
	Input:
	        10
	     /      \
	    20       30
	  /   \
	 40   60
	Output:
	10 20 30 40 60
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT6LevelOrderTraversal {

    /**
     * Performs a level-order traversal of the binary tree and returns a list of node values.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(n), where n is the number of nodes in the tree. This accounts for the space used by the queue.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList of integers representing the node values in level-order traversal.
     */
    public static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> levelOrderNodes = new ArrayList<>();
        if (root == null) {
            return levelOrderNodes; // Return an empty list if the tree is empty
        }
        
        Queue<Node> q = new LinkedList<>(); // Initialize a queue to help with level-order traversal
        q.add(root); // Add the root node to the queue
        
        while (!q.isEmpty()) {
            Node current = q.poll(); // Remove the front node from the queue
            levelOrderNodes.add(current.data); // Add the node's value to the result list
            
            if (current.left != null) {
                q.add(current.left); // Add the left child to the queue if it exists
            }
            
            if (current.right != null) {
                q.add(current.right); // Add the right child to the queue if it exists
            }
        }
        
        return levelOrderNodes; // Return the list of node values in level-order
    }
}
