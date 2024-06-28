/**
 * 	Given a BST and an integer K. Find the Kth Smallest element in the BST using O(1) extra space. 
	
	Example 1:
	Input:
	      2
	    /   \
	   1     3
	K = 2
	Output: 2
	Explanation: 2 is the 2nd smallest element in the BST
	
	Example 2:
	Input:
	        2
	      /  \
	     1    3
	K = 5
	Output: -1
	Explanation: There is no 5th smallest element in the BST as the size of BST is 3
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST8KthSmallestInBST {
	
	//SOLUTION 1: Simple in order and return kth element if present

    /**
     * Finds the Kth smallest element in the BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the root node of the BST
     * @param K the position (1-based) of the smallest element to find
     * @return the Kth smallest element's value, or -1 if K is invalid
     */
    public static int KthSmallestElement(Node root, int K) {
        int counter[] = {0}; // To count the nodes visited
        int kthSmallest[] = {-1}; // To store the Kth smallest value
        inOrder(root, K, counter, kthSmallest);
        return kthSmallest[0];
    }

    /**
     * Performs in-order traversal of the BST.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     *
     * @param root the current node
     * @param K the position (1-based) of the smallest element to find
     * @param counter an array to count the nodes visited
     * @param kthSmallest an array to store the Kth smallest value
     */
    private static void inOrder(Node root, int K, int counter[], int kthSmallest[]) {
        if (root == null || counter[0] >= K) {
            return; // Return if the node is null or the Kth element is found
        }

        // Recur on the left subtree
        inOrder(root.left, K, counter, kthSmallest);

        // Increment the counter
        counter[0]++;
        if (counter[0] == K) {
            kthSmallest[0] = root.data; // Store the Kth smallest value
            return; // Return if the Kth element is found
        }

        // Recur on the right subtree
        inOrder(root.right, K, counter, kthSmallest);
    }
}
