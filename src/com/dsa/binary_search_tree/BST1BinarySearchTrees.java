/**
 * 	Given an array of integers in[] representing inorder traversal of elements of a binary tree. Return true if the given inorder traversal can be of a valid Binary Search Tree.
	
	Note - All the keys in BST must be unique
	
	 
	
	Example 1:
	
	Input: in = [8, 14, 45, 64, 100]
	Output: True
	Example 2:
	
	Input: in[] = [5, 6, 1, 8, 7]
	Output: False
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST1BinarySearchTrees {

    /**
     * This method checks if a given array is a valid in-order traversal of a Binary Search Tree (BST).
     * In a valid in-order traversal of a BST, each element must be greater than the previous element.
     *
     * Time Complexity: O(N) - We traverse the array once.
     * Space Complexity: O(1) - No additional space is used, only a few extra variables.
     *
     * @param nums the input array representing the in-order traversal of a BST
     * @return true if the array is a valid in-order traversal of a BST, false otherwise
     */
    static boolean isBSTTraversal(int[] nums) {
        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is less than or equal to the previous element
            if (nums[i] <= nums[i - 1]) {
                return false; // If it is, the array is not a valid in-order traversal of a BST
            }
        }
        // If all elements are in strictly increasing order, the array is a valid in-order traversal of a BST
        return true;
    }

    // Main method to test the isBSTTraversal function
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 2, 4, 5};
        int[] nums3 = {5, 4, 3, 2, 1};

        System.out.println(isBSTTraversal(nums1)); // Should print true
        System.out.println(isBSTTraversal(nums2)); // Should print false
        System.out.println(isBSTTraversal(nums3)); // Should print false
    }
}
