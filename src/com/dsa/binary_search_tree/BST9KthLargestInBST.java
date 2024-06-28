/**
 * 	Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

	Example 1:
	Input:
	      4
	    /   \
	   2     9
	k = 2 
	Output: 4

	Example 2:
	Input:
	       9
	        \ 
	          10
	K = 1
	Output: 10

 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST9KthLargestInBST {
	
	//SOLUTION 1: In order traversal then return n-kth element

    /**
     * Finds the Kth largest element in the BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the root node of the BST
     * @param K the position (1-based) of the largest element to find
     * @return the Kth largest element's value, or Integer.MIN_VALUE if K is invalid
     */
    public int kthLargest(Node root, int K) {
        int[] counter = {0}; // To count the nodes visited
        int[] kthLargest = {Integer.MIN_VALUE}; // To store the Kth largest value
        reverseInOrder(root, K, counter, kthLargest);
        return kthLargest[0];
    }

    /**
     * Performs reverse in-order traversal of the BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the current node
     * @param K the position (1-based) of the largest element to find
     * @param counter an array to count the nodes visited
     * @param kthLargest an array to store the Kth largest value
     */
    private void reverseInOrder(Node root, int K, int[] counter, int[] kthLargest) {
        if (root == null) {
            return; // Return if the node is null
        }

        // Recur on the right subtree first (to get the largest elements first)
        reverseInOrder(root.right, K, counter, kthLargest);
        
        // Increment the counter
        counter[0]++;
        if (counter[0] == K) {
            kthLargest[0] = root.data; // Store the Kth largest value
            return; // Return if the Kth element is found
        }

        // Recur on the left subtree
        reverseInOrder(root.left, K, counter, kthLargest);
    }
}
