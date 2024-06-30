/**
 * 	Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
	
	BSTIterator(Node root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
	boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
	int next() Moves the pointer to the right, then returns the number at the pointer.
	Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
	
	You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
	
	 
	
	Example 1:
	Input
	["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
	[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
	Output
	[null, 3, 7, true, 9, true, 15, true, 20, false]
	
	Explanation
	BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
	bSTIterator.next();    // return 3
	bSTIterator.next();    // return 7
	bSTIterator.hasNext(); // return True
	bSTIterator.next();    // return 9
	bSTIterator.hasNext(); // return True
	bSTIterator.next();    // return 15
	bSTIterator.hasNext(); // return True
	bSTIterator.next();    // return 20
	bSTIterator.hasNext(); // return False
 */
package com.dsa.binary_search_tree;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST14BSTIterator {

	private Stack<Node> stack;

	/**
	 * Constructor to initialize the iterator with the root of the BST.
	 * 
	 * @param root
	 *            the root of the BST
	 */
	public BST14BSTIterator(Node root) {
		stack = new Stack<>(); // Initialize the stack
		pushAll(root); // Push all left nodes from the root to the stack
	}

	/**
	 * Push all left nodes from the given node to the stack.
	 * 
	 * @param root
	 *            the node to start from
	 */
	private void pushAll(Node root) {
		Node current = root; // Start with the given node

		while (current != null) { // Traverse to the leftmost node
			stack.push(current); // Push the current node to the stack
			current = current.left; // Move to the left child
		}
	}

	/**
	 * Returns the next smallest number in the BST.
	 * 
	 * @return the next smallest number
	 */
	public int next() {
		Node top = stack.pop(); // Pop the top node from the stack
		pushAll(top.right); // Push all left nodes from the right child of the
							// popped node
		return top.data; // Return the data of the popped node
	}

	/**
	 * Checks if there is a next smallest number in the BST.
	 * 
	 * @return true if there is a next smallest number, false otherwise
	 */
	public boolean hasNext() {
		return !stack.isEmpty(); // Return true if the stack is not empty
	}
}
