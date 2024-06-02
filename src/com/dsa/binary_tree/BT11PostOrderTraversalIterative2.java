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
import java.util.Stack;

public class BT11PostOrderTraversalIterative2 {

    /**
     * Performs a post-order traversal of the binary tree iteratively using a single stack.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * Space Complexity: O(n), where n is the number of nodes in the tree. In the worst case, the stack can hold all the nodes.
     *
     * @param node The root node of the binary tree.
     * @return A list containing the node values in post-order traversal.
     */
    public static ArrayList<Integer> postOrder(Node node) {
        // Initialize a stack to help with the traversal and a list to store the result
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Start with the root node
        Node current = node;

        // Iterate while there are nodes to be processed or the stack is not empty
        while (current != null || !stack.isEmpty()) {

            // Traverse to the leftmost node
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // Check the right child of the node at the top of the stack
                Node temp = stack.peek().right;
                
                // If the right child is null, process the node at the top of the stack
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.data);

                    // Continue processing the stack until we find a node that is not a right child
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        result.add(temp.data);
                    }
                } else {
                    // If the right child is not null, move to the right child
                    current = temp;
                }
            }
        }

        // Return the list containing post-order traversal node values
        return result;
    }
}
