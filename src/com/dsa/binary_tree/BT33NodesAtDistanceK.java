/**
 * 	Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available.
	Note:
	You have to return the list in sorted order.
	The tree will not contain duplicate values.

	Example 1:
	Input:      
	          20
	        /    \
	      8       22 
	    /   \
	   4    12 
	       /   \
	      10    14
	Target Node = 8
	K = 2
	Output: 10 14 22
	Explanation: The three nodes at distance 2
	from node 8 are 10, 14, 22.
	
	Example 2:
	Input:      
	         20
	       /    \
	      7      24
	    /   \
	   4     3
	        /  
	       1    
	Target Node = 7
	K = 2
	Output: 1 24
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class BT33NodesAtDistanceK {

    /**
     * Finds all nodes at distance k from the target node in a binary tree.
     *
     * @param root The root of the binary tree.
     * @param target The value of the target node.
     * @param k The distance k.
     * @return A list of node values at distance k from the target node.
     */
    public static List<Integer> KDistanceNodes(Node root, int target, int k) {
        HashMap<Node, Node> parents = new HashMap<>();
        // Find the target node and mark the parent of each node
        Node targetNode = getNodeAndMarkParents(root, target, parents);

        // Map to keep track of visited nodes to avoid revisiting them
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        int currentLevel = 0;
        q.add(targetNode);
        visited.put(targetNode, true);

        // Perform BFS to find nodes at distance k
        while (!q.isEmpty()) {
            int size = q.size();
            if (currentLevel == k) {
                break;
            }
            currentLevel++;

            for (int i = 1; i <= size; i++) {
                Node temp = q.poll();
                // Check the left child
                if (temp.left != null && visited.get(temp.left) == null) {
                    q.add(temp.left);
                    visited.put(temp.left, true);
                }
                // Check the right child
                if (temp.right != null && visited.get(temp.right) == null) {
                    q.add(temp.right);
                    visited.put(temp.right, true);
                }
                // Check the parent node
                if (parents.get(temp) != null && visited.get(parents.get(temp)) == null) {
                    q.add(parents.get(temp));
                    visited.put(parents.get(temp), true);
                }
            }
        }

        // Collect the result from the queue
        Set<Integer> result = new TreeSet<>();
        while (!q.isEmpty()) {
            result.add(q.poll().data);
        }
        return new ArrayList<>(result);
    }

    /**
     * Marks parents of all nodes in the binary tree and finds the target node.
     *
     * @param root The root of the binary tree.
     * @param target The value of the target node.
     * @param parents A map to store the parent of each node.
     * @return The target node.
     */
    private static Node getNodeAndMarkParents(Node root, int target, HashMap<Node, Node> parents) {
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Perform BFS to mark the parent of each node
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
