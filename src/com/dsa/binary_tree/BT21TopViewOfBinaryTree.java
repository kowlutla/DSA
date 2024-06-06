/**
 * 	Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
	
	       1
	    /     \
	   2       3
	  /  \    /   \
	4    5  6   7
	
	Top view will be: 4 2 1 3 7
	Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost). 
	For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.
	
	Example 1:
	
	Input:
	      1
	   /    \
	  2      3
	Output: 2 1 3
	Example 2:
	
	Input:
	       10
	    /      \
	  20        30
	 /   \    /    \
	40   60  90    100
	Output: 40 20 10 30 100

 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT21TopViewOfBinaryTree {

    static class Pair {
        Node node;
        int hd; // horizontal distance

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /**
     * Returns the top view of a binary tree as a list of node values.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Each node is processed exactly once.
     * 
     * Space Complexity: O(N) - for storing the nodes in the TreeMap and Queue.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the top view of the binary tree.
     */
    static ArrayList<Integer> topView(Node root) {
        // List to store the result of the top view
        ArrayList<Integer> topview = new ArrayList<>();

        // TreeMap to store the first node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue to perform breadth-first search
        Queue<Pair> q = new LinkedList<>();

        // Start with the root node at horizontal distance 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair currentPair = q.poll(); // Remove and get the front of the queue
            Node currentNode = currentPair.node;
            int currentHd = currentPair.hd; // Horizontal distance of the current node

            // If this horizontal distance is not in the map, add the current node's data
            if (!map.containsKey(currentHd)) {
                map.put(currentHd, currentNode.data);
            }

            // If left child exists, add it to the queue with horizontal distance - 1
            if (currentNode.left != null) {
                q.add(new Pair(currentNode.left, currentHd - 1));
            }

            // If right child exists, add it to the queue with horizontal distance + 1
            if (currentNode.right != null) {
                q.add(new Pair(currentNode.right, currentHd + 1));
            }
        }

        // Collect the values from the map into the topview list
        topview = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toCollection(ArrayList::new));

        return topview; // Return the list containing the top view of the binary tree
    }
}
