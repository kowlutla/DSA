/**
 * 	Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.

	Note: The tree contains unique values.
	
	Example 1:
	Input:      
	          1
	        /   \
	      2      3
	    /  \      \
	   4    5      6
	       / \      \
	      7   8      9
	                   \
	                   10
	Target Node = 8
	Output: 7
	Explanation: If leaf with the value 
	8 is set on fire. 
	After 1 sec: 5 is set on fire.
	After 2 sec: 2, 7 are set to fire.
	After 3 sec: 4, 1 are set to fire.
	After 4 sec: 3 is set to fire.
	After 5 sec: 6 is set to fire.
	After 6 sec: 9 is set to fire.
	After 7 sec: 10 is set to fire.
	It takes 7s to burn the complete tree.
	
	Example 2:
	Input:      
	          1
	        /   \
	      2      3
	    /  \      \
	   4    5      7
	  /    / 
	 8    10
	Target Node = 10
	Output: 5
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BT34BurningTree {

    /**
     * Calculates the minimum time required to burn the entire tree starting from a target node.
     *
     * @param root The root of the binary tree.
     * @param target The value of the target node.
     * @return The minimum time to burn the entire tree.
     * 
     * Time Complexity: O(N)
     * This method performs a BFS traversal of the tree.
     * 
     * Space Complexity: O(N)
     * The space complexity is due to the storage for the BFS queue and visited map.
     */
    public static int minTime(Node root, int target) {
        // HashMap to store the parent references for each node
        HashMap<Node, Node> parents = new HashMap<>();
        // Get the target node and mark the parent nodes
        Node targetNode = getTargetNodeAndMarkParents(root, target, parents);

        // Map to keep track of visited nodes
        Map<Node, Boolean> visited = new HashMap<>();
        // Queue for BFS traversal
        Queue<Node> q = new LinkedList<>();
        int currentTime = 0;
        // Add the target node to the queue and mark it as visited
        q.add(targetNode);
        visited.put(targetNode, true);

        // Perform BFS to simulate burning process
        while (!q.isEmpty()) {
            boolean burned = false;
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                Node current = q.poll();

                // Check and add left child to the queue if not visited
                if (current.left != null && visited.get(current.left) == null) {
                    visited.put(current.left, true);
                    burned = true;
                    q.add(current.left);
                }

                // Check and add right child to the queue if not visited
                if (current.right != null && visited.get(current.right) == null) {
                    visited.put(current.right, true);
                    burned = true;
                    q.add(current.right);
                }

                // Check and add parent to the queue if not visited
                Node parent = parents.get(current);
                if (parent != null && visited.get(parent) == null) {
                    visited.put(parent, true);
                    burned = true;
                    q.add(parent);
                }
            }
            // Increment the time only if any node burned in this level
            if (burned)
                currentTime++;
        }

        return currentTime;
    }

    /**
     * Finds the target node and marks the parents of all nodes in the binary tree.
     *
     * @param root The root of the binary tree.
     * @param target The value of the target node.
     * @param parents A map to store the parent of each node.
     * @return The target node.
     * 
     * Time Complexity: O(N)
     * This method performs a BFS traversal of the tree.
     * 
     * Space Complexity: O(N)
     * The space complexity is due to the storage for the parents map and BFS queue.
     */
    private static Node getTargetNodeAndMarkParents(Node root, int target, HashMap<Node, Node> parents) {
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Perform BFS to mark the parent of each node and find the target node
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                Node current = q.poll();
                // Check if the current node is the target node
                if (current.data == target) {
                    targetNode = current;
                }

                // Mark the parent of the left child
                if (current.left != null) {
                    parents.put(current.left, current);
                    q.add(current.left);
                }

                // Mark the parent of the right child
                if (current.right != null) {
                    parents.put(current.right, current);
                    q.add(current.right);
                }
            }
        }
        return targetNode;
    }

}
