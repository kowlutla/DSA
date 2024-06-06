/**
 * 	Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

	Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
	Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
	Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
	Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
	
	Example 1:
	
	Input:
	        1 
	      /   \
	     2     3  
	    / \   / \ 
	   4   5 6   7
	      / \
	     8   9
	   
	Output: 1 2 4 8 9 6 7 3
	
	Example 2:
	Input:
	            1
	           /
	          2
	        /  \
	       4    9
	     /  \    \
	    6    5    3
	             /  \
	            7     8
	
	Output: 1 2 4 6 5 7 8

 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT19BoundaryTraversalOfBinaryTree {

    /**
     * Performs boundary traversal of a binary tree and returns the boundary nodes as a list.
     *
     * @param node The root node of the binary tree.
     * @return A list containing the boundary nodes of the binary tree.
     */
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result; // If the root node is null, return an empty list.
        
        if (!isLeaf(node)) { // If the root is not a leaf node, add it to the result.
            result.add(node.data);
        }
        
        addLeftView(node, result); // Add the left boundary nodes to the result.
        addLeafs(node, result); // Add all the leaf nodes to the result.
        addRightView(node, result); // Add the right boundary nodes to the result.
        
        return result; // Return the list containing the boundary nodes.
    }

    /**
     * Adds the left boundary nodes to the result list, excluding the leaf nodes.
     *
     * @param node The root node of the binary tree.
     * @param result The list to store the boundary nodes.
     */
    void addLeftView(Node node, ArrayList<Integer> result) {
        Node temp = node.left; // Start from the left child of the root node.
        while (temp != null) { // Traverse down the left side of the tree.
            if (!isLeaf(temp)) { // If the node is not a leaf, add it to the result.
                result.add(temp.data);
            }
            if (temp.left != null) { // Move to the left child if it exists.
                temp = temp.left;
            } else { // If no left child, move to the right child.
                temp = temp.right;
            }
        }
    }

    /**
     * Adds all the leaf nodes to the result list.
     *
     * @param node The root node of the binary tree.
     * @param result The list to store the boundary nodes.
     */
    void addLeafs(Node node, ArrayList<Integer> result) {
        if (isLeaf(node)) { // If the node is a leaf, add it to the result.
            result.add(node.data);
        }
        if (node.left != null) { // Recursively add leaf nodes from the left subtree.
            addLeafs(node.left, result);
        }
        if (node.right != null) { // Recursively add leaf nodes from the right subtree.
            addLeafs(node.right, result);
        }
    }

    /**
     * Adds the right boundary nodes to the result list, excluding the leaf nodes.
     *
     * @param node The root node of the binary tree.
     * @param result The list to store the boundary nodes.
     */
    void addRightView(Node node, ArrayList<Integer> result) {
        Node temp = node.right; // Start from the right child of the root node.
        Stack<Integer> stack = new Stack<>(); // Use a stack to store the right boundary nodes in reverse order.
        while (temp != null) { // Traverse down the right side of the tree.
            if (!isLeaf(temp)) { // If the node is not a leaf, add it to the stack.
                stack.add(temp.data);
            }
            if (temp.right != null) { // Move to the right child if it exists.
                temp = temp.right;
            } else { // If no right child, move to the left child.
                temp = temp.left;
            }
        }
        while (!stack.isEmpty()) { // Add the right boundary nodes from the stack to the result.
            result.add(stack.pop());
        }
    }

    /**
     * Checks if a node is a leaf node.
     *
     * @param node The node to check.
     * @return True if the node is a leaf, otherwise false.
     */
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null; // A node is a leaf if it has no children.
    }
}
