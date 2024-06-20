/**
 * 	Given a BST and a number X, find Ceil of X.
	Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
	
	If Ceil could not be found, return -1.
	
	Example 1:
	Input:
	      5
	    /   \
	   1     7
	    \
	     2 
	      \
	       3
	X = 3
	Output: 3
	Explanation: We find 3 in BST, so ceil
	of 3 is 3.

	Example 2:
	Input:
	     10
	    /  \
	   5    11
	  / \ 
	 4   7
	      \
	       8
	X = 6
	Output: 7
	Explanation: We find 7 in BST, so ceil
	of 6 is 7.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST4Ceil {

    /**
     * Finds the ceiling value of a given key in a Binary Search Tree (BST).
     * The ceiling value is the smallest element in the BST that is greater than
     * or equal to the given key.
     * 
     * Time Complexity: O(H) - where H is the height of the BST.
     * Space Complexity: O(1) - no additional space used other than a few extra variables.
     *
     * @param root the root node of the BST
     * @param key the value to find the ceiling for
     * @return the ceiling value, or -1 if no such value exists
     */
    int findCeil(Node root, int key) {
        // Start from the root node
        Node current = root;
        // Initialize answer to -1, assuming no ceiling value found
        int ans = -1;

        // Traverse the tree until current node is null
        while (current != null) {
            // If current node's value equals the key, that's the exact ceiling value
            if (current.data == key) {
                return current.data;
            }
            // If current node's value is greater than the key, update answer and move to the left subtree
            if (current.data > key) {
                ans = current.data;
                current = current.left;
            } else {
                // If current node's value is less than the key, move to the right subtree
                current = current.right;
            }
        }
        // Return the ceiling value found, or -1 if no ceiling value exists
        return ans;
    }

    // Main method to test the findCeil function
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        BST4Ceil bst = new BST4Ceil();
        
        System.out.println("Ceiling of 6: " + bst.findCeil(root, 6));  // Should print 7
        System.out.println("Ceiling of 10: " + bst.findCeil(root, 10)); // Should print 10
        System.out.println("Ceiling of 17: " + bst.findCeil(root, 17)); // Should print 18
        System.out.println("Ceiling of 20: " + bst.findCeil(root, 20)); // Should print -1
    }
}
