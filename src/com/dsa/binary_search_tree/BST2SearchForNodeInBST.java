/**
 *	Given a Binary Search Tree and a node value X, find if the node with value X is present in the BST or not.

	Example 1:
	Input:         2
	                \
	                 81 
	               /    \ 
	             42      87 
	              \       \ 
	               66      90 
	              / 
	            45
	X = 87
	Output: 1
	Explanation: As 87 is present in the
	given nodes , so the output will be
	1.
	
	
	Example 2:
	
	Input:      6
	             \ 
	              8 
	             / \ 
	            7   9
	X = 11
	Output: 0
	Explanation: As 11 is not present in 
	the given nodes , so the output will
	be 0. 
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST2SearchForNodeInBST {

    /**
     * This method performs a recursive search for a given value in a Binary Search Tree (BST).
     * 
     * Time Complexity: O(H) - where H is the height of the BST.
     * Space Complexity: O(H) - due to the recursion stack.
     *
     * @param root the root node of the BST
     * @param x the value to search for
     * @return true if the value is found in the BST, false otherwise
     */
    public static boolean search1(Node root, int x) {
        // If the current node is null, the value is not found
        if (root == null) {
            return false;
        }
        // If the current node's value matches the search value, return true
        if (root.data == x) {
            return true;
        }
        // Recursively search the right subtree if the current node's value is less than the search value
        // Otherwise, search the left subtree
        return root.data < x ? search1(root.right, x) : search1(root.left, x);
    }

    /**
     * This method performs an iterative search for a given value in a Binary Search Tree (BST).
     * 
     * Time Complexity: O(H) - where H is the height of the BST.
     * Space Complexity: O(1) - no additional space used other than a few extra variables.
     *
     * @param root the root node of the BST
     * @param x the value to search for
     * @return true if the value is found in the BST, false otherwise
     */
    public static boolean search2(Node root, int x) {
        // If the root node is null, the value is not found
        if (root == null) {
            return false;
        }

        // Start from the root node
        Node current = root;
        // Iterate through the tree until the current node is null or the value is found
        while (current != null && current.data != x) {
            // Move to the right subtree if the current node's value is less than the search value
            // Otherwise, move to the left subtree
            current = current.data < x ? current.right : current.left;
        }

        // Return true if the value is found (current is not null), otherwise false
        return current != null;
    }

    // Main method to test the search functions
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        int searchValue1 = 7;
        int searchValue2 = 11;

        System.out.println("Recursive search for " + searchValue1 + ": " + search1(root, searchValue1)); // Should print true
        System.out.println("Recursive search for " + searchValue2 + ": " + search1(root, searchValue2)); // Should print false

        System.out.println("Iterative search for " + searchValue1 + ": " + search2(root, searchValue1)); // Should print true
        System.out.println("Iterative search for " + searchValue2 + ": " + search2(root, searchValue2)); // Should print false
    }
}