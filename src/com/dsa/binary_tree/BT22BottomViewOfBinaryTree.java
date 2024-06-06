/**
 * 	Given a binary tree, print the bottom view from left to right.
	A node is included in bottom view if it can be seen when we look at the tree from bottom.
	
	                      20
	                    /    \
	                  8       22
	                /   \        \
	              5      3       25
	                    /   \      
	                  10    14
	
	For the above tree, the bottom view is 5 10 3 14 25.
	If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.
	
	                      20
	                    /    \
	                  8       22
	                /   \     /   \
	              5      3 4     25
	                     /    \      
	                 10       14
	
	For the above tree the output should be 5 10 4 14 25.
	
	Example 1:
	Input:
	       1
	     /   \
	    3     2
	Output: 3 1 2
	Explanation:
	First case represents a tree with 3 nodes
	and 2 edges where root is 1, left child of
	1 is 3 and right child of 1 is 2.
	Thus nodes of the binary tree will be
	printed as such 3 1 2.

	
	Example 2:
	Input:
	         10
	       /    \
	      20    30
	     /  \
	    40   60
	Output: 40 20 60 30
	
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
public class BT22BottomViewOfBinaryTree {

    class Pair {
        Node node;
        int hd; // horizontal distance

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /**
     * Computes the bottom view of a binary tree where nodes do not maintain horizontal distance.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - for storing nodes in the TreeMap and Queue.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList containing the bottom view of the binary tree.
     */
    public ArrayList<Integer> bottomView1(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // to store the bottom view nodes
        Queue<Pair> q = new LinkedList<>(); // for level-order traversal

        q.add(new Pair(root, 0)); // start with the root node at horizontal distance 0

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();
            Node currentNode = currentPair.node;
            int currentHd = currentPair.hd; // horizontal distance

            map.put(currentHd, currentNode.data); // update the map with the latest node at this horizontal distance

            if (currentNode.left != null) {
                q.add(new Pair(currentNode.left, currentHd - 1)); // left child has horizontal distance -1
            }
            if (currentNode.right != null) {
                q.add(new Pair(currentNode.right, currentHd + 1)); // right child has horizontal distance +1
            }
        }

        ArrayList<Integer> bottomView = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bottomView.add(entry.getValue()); // collect the bottom view nodes
        }
        return bottomView;
    }

    /**
     * Computes the bottom view of a binary tree where nodes maintain horizontal distance.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - for storing nodes in the TreeMap and Queue.
     *
     * @param root The root node of the binary tree.
     * @return An ArrayList containing the bottom view of the binary tree.
     */
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // to store the bottom view nodes
        Queue<Node> q = new LinkedList<>(); // for level-order traversal

        root.hd = 0; // initialize the root node's horizontal distance to 0
        q.add(root);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int currentHd = currentNode.hd; // horizontal distance

            map.put(currentHd, currentNode.data); // update the map with the latest node at this horizontal distance

            if (currentNode.left != null) {
                currentNode.left.hd = currentHd - 1; // left child has horizontal distance -1
                q.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.hd = currentHd + 1; // right child has horizontal distance +1
                q.add(currentNode.right);
            }
        }

        ArrayList<Integer> bottomView = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bottomView.add(entry.getValue()); // collect the bottom view nodes
        }
        return bottomView;
    }

    class Node {
        int data; // data of the node
        int hd; // horizontal distance of the node
        Node left, right; // left and right references

        // Constructor of tree node
        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE; // initialize horizontal distance to a large value
            left = right = null;
        }
    }
}
