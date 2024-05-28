/**
 * 	You are given an array nodes. It contains 7 integers, which represents the value of nodes of the binary tree in level order traversal. You are also given a root of the tree which has a value equal to nodes[0].

	Your task to construct a binary tree by creating nodes for the remaining 6 nodes.
	
	Example:
	Input: 
	nodes = [1 2 3 4 5 6 7]
	Output: 
	         1
	       /   \
	     2       3
	   /  \     /  \
	   4  5    6   7
	Explanation: 
	The 7 node binary tree is represented above.
 */
package com.dsa.binary_tree;

import java.util.ArrayList;

public class BT2BinaryTreeRepresentation {

    /**
     * Creates a binary tree from a given list of integers.
     * The list must contain at least 7 elements to fill a complete binary tree of height 2.
     *
     * @param root The root node of the binary tree.
     * @param v    The list of integers to create the tree nodes from.
     */
    public static void createTree(Node root, ArrayList<Integer> v) {
        // Check if the list has at least 7 elements
        if (v.size() < 7) {
            throw new IllegalArgumentException("The list must contain at least 7 elements.");
        }

        // Create the binary tree nodes based on the given list
        // The first element of the list is assumed to be at index 1
        // Create the left child of the root
        root.left = new Node(v.get(1));
        // Create the right child of the root
        root.right = new Node(v.get(2));
        // Create the left child of the root's left child
        root.left.left = new Node(v.get(3));
        // Create the right child of the root's left child
        root.left.right = new Node(v.get(4));
        // Create the left child of the root's right child
        root.right.left = new Node(v.get(5));
        // Create the right child of the root's right child
        root.right.right = new Node(v.get(6));
    }
}
