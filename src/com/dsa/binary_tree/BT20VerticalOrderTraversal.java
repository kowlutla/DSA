/**
 * 	Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
	If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.
	
	Example 1:
	Input:
	           1
	         /   \
	       2       3
	     /   \   /   \
	   4      5 6      7
	              \      \
	               8      9           
	Output: 
	4 2 1 5 6 3 8 7 9 
	
	Example 2:
	Input:
	       1
	    /    \
	   2       3
	 /    \      \
	4      5      6
	Output: 4 2 1 5 3 6
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT20VerticalOrderTraversal {

    /**
     * Performs vertical order traversal of a binary tree and returns the nodes in a list.
     *
     * Time Complexity: O(N log N) - where N is the number of nodes in the binary tree.
     * The complexity is dominated by the TreeMap operations which have log N complexity.
     * 
     * Space Complexity: O(N) - for storing the nodes in the TreeMap and Queue.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the nodes in vertical order.
     */
    static ArrayList<Integer> verticalOrder(Node root) {
        // TreeMap to store nodes at each horizontal distance
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Helper method to populate the TreeMap
        verticalOrder(root, map);
        // List to store the final vertical order traversal
        ArrayList<Integer> result = new ArrayList<>();

        // Add all nodes in the vertical order to the result list
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            result.addAll(e.getValue());
        }

        return result; // Return the list containing nodes in vertical order
    }

    static class Pair {
        Node node;
        int hd; // horizontal distance

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /**
     * Helper method to perform vertical order traversal and populate the TreeMap.
     *
     * @param root The root node of the binary tree.
     * @param map The TreeMap to store nodes at each horizontal distance.
     */
    static void verticalOrder(Node root, Map<Integer, ArrayList<Integer>> map) {

        if (root == null) {
            return; // If the root node is null, return.
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0)); // Start with the root node at horizontal distance 0

        while (!q.isEmpty()) {
            Pair pair = q.poll(); // Remove and get the front of the queue
            int hd = pair.hd; // Horizontal distance of the current node
            Node node = pair.node;

            // If horizontal distance is not in the map, add it with a new list
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }

            // Get the list of nodes at this horizontal distance and add the current node's data
            ArrayList<Integer> nodes = map.get(hd);
            nodes.add(node.data);

            // If left child exists, add it to the queue with horizontal distance - 1
            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            // If right child exists, add it to the queue with horizontal distance + 1
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }
    }
}
