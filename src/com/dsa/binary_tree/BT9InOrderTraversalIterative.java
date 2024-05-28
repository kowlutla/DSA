/**
 * 	Given a binary tree. Find the inorder traversal of the tree without using recursion.
	
	Example 1
	Input:
	           1
	         /    \
	       2       3
	      /   \
	    4     5
	Output: 4 2 5 1 3
	Explanation:
	Inorder traversal (Left->Root->Right) of 
	the tree is 4 2 5 1 3.

	Example 2
	Input:
	            8
	          /   \
	            1      5
	             \    /  \
	             7   10   6
	             \  /
	          10 6
	Output: 1 7 10 8 6 10 5 6
	Explanation:
	Inorder traversal (Left->Root->Right) 
	of the tree is 1 7 10 8 6 10 5 6.
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class BT9InOrderTraversalIterative {

    /**
     * Performs an in-order traversal of the binary tree iteratively.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(h), where h is the height of the tree. In the worst case, the stack can hold nodes up to the height of the tree.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the node values in in-order traversal.
     */
    public static ArrayList<Integer> inOrder(Node root) {
        // Initialize a list to store the in-order traversal result
        ArrayList<Integer> inOrderNodes = new ArrayList<>();
        // Initialize a current node to traverse the tree
        Node current = root;
        // Create a stack for iterative traversal
        Stack<Node> stack = new Stack<>();
        // Iterate through the stack until it is empty and current node is null
        while (current != null || !stack.isEmpty()) {
            // Push all left children onto the stack and move to the left child
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // If current node is null, pop a node from the stack, add its value to the result list, and move to its right child
                current = stack.pop();
                inOrderNodes.add(current.data);
                current = current.right;
            }
        }
        // Return the list containing in-order traversal node values
        return inOrderNodes;
    }
}
