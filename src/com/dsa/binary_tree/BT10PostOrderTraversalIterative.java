/**
 *  Given a binary tree. Find the postorder traversal of the tree without using recursion.
	
	Example 1
	
	Input:
	           1
	         /   \
	        2     3
	      /  \
	     4    5
	
	Output: 4 5 2 3 1
	Explanation:
	Postorder traversal (Left->Right->Root) of 
	the tree is 4 5 2 3 1.
	Example 2
	
	Input:
	             8
	          /      \
	        1          5
	         \       /   \
	          7     10    6
	           \   /
	            10 6
	
	Output: 10 7 1 6 10 6 5 8 
	Explanation:
	Postorder traversal (Left->Right->Root) 
	of the tree is 10 7 1 6 10 6 5 8 .
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BT10PostOrderTraversalIterative {

    /**
     * Performs a post-order traversal of the binary tree iteratively.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(n), where n is the number of nodes in the tree. In the worst case, the stack can hold all the nodes.
     *
     * @param node The root node of the binary tree.
     * @return A list containing the node values in post-order traversal.
     */
    public static ArrayList<Integer> postOrder(Node node) {
        // Initialize a list to store the post-order traversal result
        ArrayList<Integer> postOrderNodes = new ArrayList<>();

        // Create a stack to help with the iterative traversal
        Stack<Node> stack1 = new Stack<>();

        // Push the root node onto the stack
        stack1.add(node);

        // Iterate while the stack is not empty
        while (!stack1.isEmpty()) {
            // Pop the top node from the stack
            Node current = stack1.pop();

            // Add the node's value to the post-order result list
            postOrderNodes.add(current.data);

            // If the node has a left child, push it onto the stack
            if (current.left != null) {
                stack1.push(current.left);
            }

            // If the node has a right child, push it onto the stack
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // The nodes are added in a modified pre-order (root, right, left)
        // Reverse the list to get the post-order (left, right, root)
        Collections.reverse(postOrderNodes);

        // Return the list containing post-order traversal node values
        return postOrderNodes;
    }
}
