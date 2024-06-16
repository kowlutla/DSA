/**
 * 	Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.

	Example 1:
	Input:
	           5
	         /    \
	        4      6
	       /        \
	      3          7
	     /
	    1
	Output: 1

	Example 2:
	Input:
	             9
	              \
	               10
	                \
	                 11
	Output: 9
	Your Task:
	The task is to complete the function minValue() which takes root as the argument and returns the minimum element of BST. 
	If the tree is empty, there is no minimum element, so return -1 in that case.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST3MinimumInBST {

    /**
     * This method finds the minimum value in a Binary Search Tree (BST) using recursion.
     * 
     * Time Complexity: O(H) - where H is the height of the BST.
     * Space Complexity: O(H) - due to the recursion stack.
     *
     * @param root the root node of the BST
     * @return the minimum value in the BST, or -1 if the tree is empty
     */
    public static int minValue1(Node root) {
        // If the tree is empty, return -1
        if (root == null) {
            return -1;
        }
        // If the left child is null, the current node contains the minimum value
        if (root.left == null) {
            return root.data;
        }

        // Recursively call the method on the left subtree
        return minValue1(root.left);
    }

    /**
     * This method finds the minimum value in a Binary Search Tree (BST) using iteration.
     * 
     * Time Complexity: O(H) - where H is the height of the BST.
     * Space Complexity: O(1) - no additional space used other than a few extra variables.
     *
     * @param root the root node of the BST
     * @return the minimum value in the BST, or -1 if the tree is empty
     */
    public static int minValue2(Node root) {
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

    // Main method to test the minValue functions
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        System.out.println("Minimum value (recursive): " + minValue1(root)); // Should print 3
        System.out.println("Minimum value (iterative): " + minValue2(root)); // Should print 3
    }
}
