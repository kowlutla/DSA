/**
 * 	Given an integer i. Print the maximum number of nodes on level i of a binary tree.

	Example 1:
	Input: 5
	Output: 16

	Example 2:
	Input: 1
	Output: 1
 
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT1MaxNumberOfNodesAtIthLevel {

    /**
     * Calculate the maximum number of nodes at the i-th level of a complete binary tree.
     *
     * @param i the level for which to calculate the number of nodes (1-based index)
     * @return the maximum number of nodes at the i-th level
     */
    public static int countNodes(int i) {
        // The maximum number of nodes at level i in a complete binary tree is given by 2^(i-1)
        return (int) Math.pow(2, i - 1);
    }

    public static void main(String[] args) {
        // Example usage and test cases
        System.out.println(countNodes(1)); // Should print 1
        System.out.println(countNodes(2)); // Should print 2
        System.out.println(countNodes(3)); // Should print 4
        System.out.println(countNodes(4)); // Should print 8
    }
}
