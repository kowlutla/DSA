/**
 *  Given a Binary Tree with all unique values and two nodes value, n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them are present.
	
	LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.
	
	Example 1:
	
	Input:
	n1 = 2 , n2 = 3  
	       1 
	      / \ 
	     2   3
	Output: 1
	Explanation:
	LCA of 2 and 3 is 1.
	Example 2:
	
	Input:
	n1 = 3 , n2 = 4
	           5    
	          /    
	         2  
	        / \  
	       3   4
	Output: 2
	Explanation:
	LCA of 3 and 4 is 2. 
	Example 3:
	
	Input:
	n1 = 5 , n2 = 4
	           5    
	          /    
	         2  
	        / \  
	       3   4
	Output: 5
	Explanation:
	LCA of 5 and 4 is 5. 
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BT28LowestCommonAncestor {

    /**
     * Method 1: Finds the Lowest Common Ancestor (LCA) by finding the paths to the two nodes and comparing them.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - due to the space required for storing the paths.
     *
     * @param root The root node of the binary tree.
     * @param n1 The value of the first node.
     * @param n2 The value of the second node.
     * @return The LCA node.
     */
    public static Node lca1(Node root, int n1, int n2) {
        List<Integer> path1 = getPath(root, n1); // Get the path to the first node
        List<Integer> path2 = getPath(root, n2); // Get the path to the second node

        if (path1.isEmpty() || path2.isEmpty()) {
            return null; // If either path is empty, one of the nodes is not in the tree
        }

        int prev = -1;
        int size1 = path1.size();
        int size2 = path2.size();
        
        // Compare paths to find the last common node
        for (int i = 0; i < Math.min(size1, size2); i++) {
            if (!(path1.get(i).equals(path2.get(i)))) {
                break;
            }
            prev = path1.get(i);
        }
        return new Node(prev); // Return the last common node as the LCA
    }

    /**
     * Helper method to find the path from the root to a given node.
     *
     * @param root The root node of the binary tree.
     * @param x The value of the target node.
     * @return A list representing the path from the root to the target node.
     */
    private static List<Integer> getPath(Node root, int x) {
        List<Integer> path = new ArrayList<>();
        getPath(root, path, x);
        return path;
    }

    /**
     * Recursive helper method to find the path from the root to a given node.
     *
     * @param node The current node being processed.
     * @param path The current path being constructed.
     * @param x The value of the target node.
     * @return true if the path to the node is found, false otherwise.
     */
    private static boolean getPath(Node node, List<Integer> path, int x) {
        if (node == null) {
            return false; // Base case: If the node is null, return false
        }

        path.add(node.data); // Add the current node to the path
        if (node.data == x) {
            return true; // If the current node is the target node, return true
        }

        // Recursively check the left and right subtrees
        if (getPath(node.left, path, x) || getPath(node.right, path, x)) {
            return true;
        }

        // If the target node is not found in either subtree, remove the current node from the path
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Method 2: Finds the Lowest Common Ancestor (LCA) using a single traversal.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(h) - where h is the height of the binary tree for the recursion stack space.
     *
     * @param root The root node of the binary tree.
     * @param n1 The value of the first node.
     * @param n2 The value of the second node.
     * @return The LCA node.
     */
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root; // If the root is null or matches one of the target nodes, return the root
        }

        // Recursively find the LCA in the left and right subtrees
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca; // If the left subtree doesn't contain any target nodes, return the right subtree's LCA
        }
        if (rightLca == null) {
            return leftLca; // If the right subtree doesn't contain any target nodes, return the left subtree's LCA
        }
        return root; // If both subtrees contain one target node each, return the root as the LCA
    }
}