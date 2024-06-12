/**
 * 	Given the root of a binary tree, flatten the tree into a "lLinked list":

	The "linked list" should use the same Node class where the right child pointer points to the next node in the list and the left child pointer is always null.
	The "linked list" should be in the same order as a pre-order traversal of the binary tree.

	Example 1:
	Input : 
	          1
	        /   \
	       2     5
	      / \     \
	     3   4     6
	Output :
	1 2 3 4 5 6 
	Explanation: 
	After flattening, the tree looks 
	like this
	    1
	     \
	      2
	       \
	        3
	         \
	          4
	           \
	            5
	             \
	              6 
	Here, left of each node points 
	to NULL and right contains the 
	next node in preorder.The inorder 
	traversal of this flattened tree 
	is 1 2 3 4 5 6.

	Example 2:
	Input :
	        1
	       / \
	      3   4
	         /
	        2
	         \
	          5 
	Output : 
	1 3 4 2 5  
	Explanation : 
	After flattening, the tree looks 
	like this 
	     1
	      \
	       3
	        \
	         4
	          \
	           2
	            \ 
	             5 
	Here, left of each node points 
	to NULL and right contains the 
	next node in preorder.The inorder 
	traversal of this flattened tree 
	is 1 3 4 2 5.
 */
package com.dsa.binary_tree;

import java.util.Stack;

public class BT43FlattenBinaryTreeToLinkedList {

    /**
     * Flattens the binary tree to a linked list using a stack.
     * This method uses a stack to process the nodes in a depth-first manner.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the binary tree.
     * Space Complexity: O(N), due to the stack storing nodes.
     *
     * @param root The root node of the binary tree.
     */
    public static void flatten1(Node root) {
        if (root == null) return;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            
            // Push right child to stack if exists
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push left child to stack if exists
            if (current.left != null) {
                stack.push(current.left);
            }

            // Reassign current node's right to the top of the stack
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            // Set left to null
            current.left = null;
        }
    }

    /**
     * Flattens the binary tree to a linked list in place using a Morris traversal-like approach.
     * This method finds the rightmost node of the left subtree and reassigns pointers.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the binary tree.
     * Space Complexity: O(1), since it uses constant extra space.
     *
     * @param root The root node of the binary tree.
     */
    public static void flatten2(Node root) {
        Node current = root;

        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                Node prev = current.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Reassign pointers
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            // Move to the right in the flattened list
            current = current.right;
        }
    }
    
    // Definition for the binary tree node
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Main method to test flattening methods
    public static void main(String[] args) {
        BT43FlattenBinaryTreeToLinkedList tree = new BT43FlattenBinaryTreeToLinkedList();
        
        // Constructing a sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        
        // Test flatten1 method
        System.out.println("Flatten using method 1:");
        tree.flatten1(root);
        printFlattenedTree(root);
        
        // Reconstructing the tree to test flatten2 method
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        
        // Test flatten2 method
        System.out.println("Flatten using method 2:");
        tree.flatten2(root);
        printFlattenedTree(root);
    }

    // Helper method to print the flattened tree
    private static void printFlattenedTree(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }
}
