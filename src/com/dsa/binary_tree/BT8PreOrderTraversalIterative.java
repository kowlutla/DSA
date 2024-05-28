/**
 * 	Given a Binary tree. Find the preorder traversal of the tree without using recursion.
	
	Example 1:
	Input:
	           1
	         /   \
	        2     3
	      /  \
	     4    5
	Output: 1 2 4 5 3
	Explanation:
	Preorder traversal (Root->Left->Right) of 
	the tree is 1 2 4 5 3.

	
	Example 2
	Input:
	            8
	          /   \
	         1      5
	          \    /  \
	           7  10   6
	            \  /
	            10 6
	Output: 8 1 7 10 5 10 6 6 
	Explanation:
	Preorder traversal (Root->Left->Right) 
	of the tree is 8 1 7 10 5 10 6 6.
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class BT8PreOrderTraversalIterative {

    /**
     * Performs a pre-order traversal of the binary tree iteratively.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(h), where h is the height of the tree. In the worst case, the stack can hold nodes up to the height of the tree.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the node values in pre-order traversal.
     */
    public static ArrayList<Integer> preOrder(Node root) {
        // Initialize a list to store the pre-order traversal result
        ArrayList<Integer> preOrderNodes = new ArrayList<>();
        // Check if the tree is empty
        if (root == null) {
            return preOrderNodes;
        }
        // Create a stack for iterative traversal
        Stack<Node> stack = new Stack<>();
        // Push the root node onto the stack
        stack.push(root);
        // Iterate through the stack until it is empty
        while (!stack.isEmpty()) {
            // Pop the top node from the stack
            Node current = stack.pop();
            // Add the value of the current node to the result list
            preOrderNodes.add(current.data);
            // Push the right child onto the stack if it exists
            if (current.right != null) {
                stack.push(current.right);
            }
            // Push the left child onto the stack if it exists
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        // Return the list containing pre-order traversal node values
        return preOrderNodes;
    }
}
