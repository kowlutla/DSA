/**
 * 	Given two binary trees, the task is to find if both of them are identical or not.
	Note: You need to return true or false, the printing is done by the driver code.
	
	Example 1:
	Input:
	     1          1
	   /   \      /   \
	  2     3    2     3
	Output: 
	Yes
	Explanation: 
	There are two trees both having 3 nodes and 2 edges, both trees are identical having the root as 1, left child of 1 is 2 and right child of 1 is 3.

	Example 2:
	Input:
	    1       1
	  /  \     /  \
	 2    3   3    2
	Output: 
	No
	Explanation: There are two trees both having 3 nodes and 2 edges, but both trees are not identical.
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT17CheckTwoBinaryTreesIdentical {

    /**
     * Checks if two binary trees are identical.
     * Two binary trees are considered identical if they have the same structure and nodes have the same value.
     *
     * Time Complexity: O(n), where n is the number of nodes in the smaller tree.
     * Space Complexity: O(h), where h is the height of the smaller tree (due to the recursion stack).
     *
     * @param root1 The root node of the first binary tree.
     * @param root2 The root node of the second binary tree.
     * @return True if both binary trees are identical, otherwise false.
     */
    boolean isIdentical(Node root1, Node root2) {
        // If either root is null, check if both are null (both trees are empty)
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        // Check if the current nodes have the same value and
        // recursively check the left and right subtrees
        return (root1.data == root2.data) && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }
}
