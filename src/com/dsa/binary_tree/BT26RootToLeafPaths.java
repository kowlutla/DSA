/**
 * 	Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
	
	Example 1:
	Input:
	       1
	    /     \
	   2       3
	Output: 
	1 2 
	1 3 
	Explanation: 
	All possible paths:
	1->2
	1->3

	Example 2:
	Input:
	         10
	       /    \
	      20    30
	     /  \
	    40   60
	Output: 
	10 20 40 
	10 20 60 
	10 30 
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT26RootToLeafPaths {

    /**
     * Finds all root-to-leaf paths in a binary tree.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N * h) - where h is the height of the binary tree for storing paths,
     * and O(h) for the recursion stack space.
     *
     * @param root The root node of the binary tree.
     * @return A list of all root-to-leaf paths, each path represented as a list of integers.
     */
    public static List<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        paths(root, result, currentPath);
        return result;
    }

    /**
     * Helper method to recursively find all root-to-leaf paths.
     * 
     * @param node The current node being processed.
     * @param result The list to store all root-to-leaf paths.
     * @param currentPath The current path being constructed.
     */
    private static void paths(Node node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath) {
        if (node == null) {
            return; // Base case: If the node is null, return
        }
        
        currentPath.add(node.data); // Add the current node to the path

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath)); // If it's a leaf, add the path to the result
        } else {
            paths(node.left, result, new ArrayList<>(currentPath)); // Recurse on the left child
            paths(node.right, result, new ArrayList<>(currentPath)); // Recurse on the right child
        }
    }
}
