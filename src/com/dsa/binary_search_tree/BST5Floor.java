/**
 * 	You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
	Note: when x is smaller than the smallest node of BST then returns -1.
	
	Example:
	
	Input:
	n = 7               2
	                     \
	                      81
	                    /     \
	                 42       87
	                   \       \
	                    66      90
	                   /
	                 45
	x = 87
	Output:
	87
	Explanation:
	87 is present in tree so floor will be 87.
	Example 2:
	
	Input:
	n = 4                     6
	                           \
	                            8
	                          /   \
	                        7       9
	x = 11
	Output:
	9
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST5Floor {

    /**
     * Finds the floor value in a BST for a given integer x.
     * The floor value is the largest value in the BST that is less than or equal to x.
     *
     * Time Complexity: O(H)
     * The time complexity is O(H), where H is the height of the BST. In the worst case, H can be N (in a skewed BST).
     *
     * Space Complexity: O(1)
     * The space complexity is constant as we are only using a few extra variables.
     *
     * @param root the root node of the BST
     * @param x the target value to find the floor for
     * @return the floor value in the BST for the given x, or -1 if no such value exists
     */
    public static int floor(Node root, int x) {
        int floor = -1; // Initialize the floor value to -1 (indicating no floor found yet)

        Node current = root; // Start from the root node
        while (current != null) {
            if (current.data == x) {
                // If the current node's value is equal to x, it is the floor
                return current.data;
            } else if (current.data < x) {
                // If the current node's value is less than x, update the floor and move to the right subtree
                floor = current.data;
                current = current.right;
            } else {
                // If the current node's value is greater than x, move to the left subtree
                current = current.left;
            }
        }

        // Return the floor value found
        return floor;
    }
}
