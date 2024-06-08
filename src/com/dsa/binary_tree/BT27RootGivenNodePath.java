/**
 * 	Given a binary tree with distinct nodes(no two nodes have the same data values). The problem is to print the path from root to a given node x. If node x is not present then print “No Path”.
	
	Examples: 
	Input :              1
	                   /   \
	                  2     3
	                /  \   /  \
	               4    5  6   7
	 x = 5
	Output : 1->2->5
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT27RootGivenNodePath {

    /**
     * Finds the path from the root to a given node in a binary tree.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(h) - where h is the height of the binary tree for the recursion stack space.
     *
     * @param root The root node of the binary tree.
     * @param x The value of the node to find the path to.
     * @return A list of integers representing the path from the root to the given node.
     */
    public List<Integer> pathFromRoot(Node root, int x) {
        List<Integer> path = new ArrayList<>();
        pathFromRoot(root, x, path);
        return path;
    }

    /**
     * Helper method to recursively find the path from the root to a given node.
     *
     * @param node The current node being processed.
     * @param x The value of the node to find the path to.
     * @param path The current path being constructed.
     * @return true if the path to the node is found, false otherwise.
     */
    private boolean pathFromRoot(Node node, int x, List<Integer> path) {
        if (node == null) {
            return false; // Base case: If the node is null, return false
        }
        path.add(node.data); // Add the current node to the path

        if (node.data == x) {
            return true; // If the current node is the target node, return true
        }

        // Recursively check the left and right subtrees
        if (pathFromRoot(node.left, x, path) || pathFromRoot(node.right, x, path)) {
            return true;
        }

        // If the target node is not found in either subtree, remove the current node from the path
        path.remove(path.size() - 1);
        return false;
    }
    
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BT27RootGivenNodePath tree = new BT27RootGivenNodePath();

        // Finding path from root to node 5
        int targetNode = 5;
        List<Integer> path = tree.pathFromRoot(root, targetNode);

        // Printing the path
        if (path.isEmpty()) {
            System.out.println("Node " + targetNode + " not found in the tree.");
        } else {
            System.out.println("Path from root to node " + targetNode + ": " + path);
        }
    }
}
