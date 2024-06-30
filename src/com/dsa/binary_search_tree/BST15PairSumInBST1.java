/**
 * 	Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 
	
	Example 1:
	Input:
	        2
	      /   \
	     1     3
	sum = 5
	Output: 1 
	Explanation: 
	Nodes with value 2 and 3 sum up to 5.

	Example 2:
	Input:
	           6
	          /    
	         5     
	        /
	       3 
	     /  \
	    1    4
	sum = 2
	Output: 0 
	Explanation: 
	There's no pair that sums up to 2.
 */
package com.dsa.binary_search_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST15PairSumInBST1 {

    /**
     * Method to check if there exists a pair with the given target sum in the BST using inorder traversal.
     * @param root the root of the BST
     * @param target the target sum to find
     * @return 1 if a pair is found, otherwise 0
     */
    public int isPairPresent1(Node root, int target) {
        List<Integer> inorder = new LinkedList<>();
        inOrder(root, inorder); // Perform inorder traversal and store the result in the list

        int left = 0, right = inorder.size() - 1; // Initialize two pointers

        while (left < right) { // While the two pointers do not cross
            int sum = inorder.get(left) + inorder.get(right); // Calculate the sum of the values at the pointers
            if (sum == target) { // If the sum matches the target
                return 1;
            } else if (sum < target) { // If the sum is less than the target, move the left pointer to the right
                left++;
            } else { // If the sum is greater than the target, move the right pointer to the left
                right--;
            }
        }

        return 0; // Return 0 if no pair is found
    }

    /**
     * Helper method to perform inorder traversal of the BST.
     * @param root the root of the BST
     * @param inorder the list to store the inorder traversal result
     */
    private void inOrder(Node root, List<Integer> inorder) {
        if (root == null) { // Base case
            return;
        }

        inOrder(root.left, inorder); // Traverse the left subtree
        inorder.add(root.data); // Add the root's data to the list
        inOrder(root.right, inorder); // Traverse the right subtree
    }

    /**
     * Method to check if there exists a pair with the given target sum in the BST using recursion and search.
     * @param root the root of the BST
     * @param target the target sum to find
     * @return 1 if a pair is found, otherwise 0
     */
    public int isPairPresent2(Node root, int target) {
        return isPresent(root, target, root) ? 1 : 0;
    }

    /**
     * Helper method to recursively check if there exists a pair with the given target sum in the BST.
     * @param root the root of the BST
     * @param target the target sum to find
     * @param currentNode the current node being processed
     * @return true if a pair is found, otherwise false
     */
    private boolean isPresent(Node root, int target, Node currentNode) {
        if (currentNode == null) { // Base case
            return false;
        }

        // Check if the required pair is present
        return search(root, target - currentNode.data, currentNode) || 
               isPresent(root, target, currentNode.left) || 
               isPresent(root, target, currentNode.right);
    }

    /**
     * Helper method to search for a value in the BST that is different from the current node.
     * @param root the root of the BST
     * @param target the value to search for
     * @param currentNode the current node being processed
     * @return true if the value is found, otherwise false
     */
    private boolean search(Node root, int target, Node currentNode) {
        Node current = root;

        while (current != null) {
            if (current != currentNode && current.data == target) { // If the value is found and it's not the current node
                return true;
            } else if (current.data < target) { // If the current value is less than the target, move to the right
                current = current.right;
            } else { // If the current value is greater than the target, move to the left
                current = current.left;
            }
        }

        return false; // Return false if the value is not found
    }
}
