/**
 * 	Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
	
	Example 1:
	
	Input:
	     10
	    /  \
	   2   -25
	  / \  /  \
	 20 1  3  4
	Output: 32
	Explanation: Path in the given tree goes
	like 10 , 2 , 20 which gives the max
	sum as 32.
	Example 2:
	
	Input:
	     10
	   /    \
	  2      5
	          \
	          -2
	Output: 17
	Explanation: Path in the given tree goes
	like 2 , 10 , 5 which gives the max sum
	as 17.
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class B16MaximumPathSumFromAnyNode {

    /**
     * Finds the maximum path sum in the binary tree where the path can start and end at any node.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(h), where h is the height of the binary tree (due to the recursion stack).
     *
     * @param node The root node of the binary tree.
     * @return The maximum path sum from any node.
     */
    int findMaxSum(Node node) {
        // Initialize an array to store the maximum path sum
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        // Utility function to find the maximum path sum
        findSumUtil(node, max);
        // Return the maximum path sum
        return max[0];
    }

    /**
     * Utility function to find the maximum path sum.
     *
     * @param node The current node being processed.
     * @param max An array to store the maximum path sum.
     * @return The maximum sum of the path ending at the current node.
     */
    int findSumUtil(Node node, int[] max) {
        // Base case: If the node is null, the sum is 0
        if (node == null) {
            return 0;
        }

        // Recursively find the maximum path sum for the left and right subtrees
        int leftSum = Math.max(0, findSumUtil(node.left, max));
        int rightSum = Math.max(0, findSumUtil(node.right, max));

        // Update the maximum path sum considering the current node
        max[0] = Math.max(max[0], leftSum + rightSum + node.data);

        // Return the maximum path sum ending at the current node
        return node.data + Math.max(leftSum, rightSum);
    }
}
