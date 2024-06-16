/**
 	Given a Binary Tree, find maximum and minimum elements in it.
	
	Example:
	Input: 
	           6
	        / \
	       5   8
	      /
	     2
	Output: 8 2
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST3MinAndMaxInBST {

	/**
	 * Finds the maximum value in a Binary Search Tree (BST) using recursion.
	 * 
	 * Time Complexity: O(H) - where H is the height of the BST. Space
	 * Complexity: O(H) - due to the recursion stack.
	 *
	 * @param root
	 *            the root node of the BST
	 * @return the maximum value in the BST, or -1 if the tree is empty
	 */
	public static int findMax1(Node root) {
		// If the tree is empty, return -1
		if (root == null) {
			return -1;
		}
		// If the right child is null, the current node contains the maximum
		// value
		if (root.right == null) {
			return root.data;
		}
		// Recursively call the method on the right subtree
		return findMax1(root.right);
	}

	/**
	 * Finds the minimum value in a Binary Search Tree (BST) using recursion.
	 * 
	 * Time Complexity: O(H) - where H is the height of the BST. Space
	 * Complexity: O(H) - due to the recursion stack.
	 *
	 * @param root
	 *            the root node of the BST
	 * @return the minimum value in the BST, or -1 if the tree is empty
	 */
	public static int findMin1(Node root) {
		// If the tree is empty, return -1
		if (root == null) {
			return -1;
		}
		// If the left child is null, the current node contains the minimum
		// value
		if (root.left == null) {
			return root.data;
		}
		// Recursively call the method on the left subtree
		return findMin1(root.left);
	}

	/**
	 * Finds the maximum value in a Binary Search Tree (BST) using iteration.
	 * 
	 * Time Complexity: O(H) - where H is the height of the BST. Space
	 * Complexity: O(1) - no additional space used other than a few extra
	 * variables.
	 *
	 * @param root
	 *            the root node of the BST
	 * @return the maximum value in the BST, or -1 if the tree is empty
	 */
	public static int findMax2(Node root) {
		// If the tree is empty, return -1
		if (root == null) {
			return -1;
		}
		// Start from the root node
		Node current = root;
		// Traverse the right subtree until the rightmost node is reached
		while (current.right != null) {
			current = current.right;
		}
		// The rightmost node contains the maximum value
		return current.data;
	}

	/**
	 * Finds the minimum value in a Binary Search Tree (BST) using iteration.
	 * 
	 * Time Complexity: O(H) - where H is the height of the BST. Space
	 * Complexity: O(1) - no additional space used other than a few extra
	 * variables.
	 *
	 * @param root
	 *            the root node of the BST
	 * @return the minimum value in the BST, or -1 if the tree is empty
	 */
	public static int findMin2(Node root) {
		// If the tree is empty, return -1
		if (root == null) {
			return -1;
		}
		// Start from the root node
		Node current = root;
		// Traverse the left subtree until the leftmost node is reached
		while (current.left != null) {
			current = current.left;
		}
		// The leftmost node contains the minimum value
		return current.data;
	}

	// Main method to test the findMin and findMax functions
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(18);

		System.out.println("Minimum value (recursive): " + findMin1(root)); // Should
		System.out.println("Minimum value (iterative): " + findMin2(root)); // Should
		System.out.println("Maximum value (recursive): " + findMax1(root)); // Should
		System.out.println("Maximum value (iterative): " + findMax2(root)); // Should
	}
}
