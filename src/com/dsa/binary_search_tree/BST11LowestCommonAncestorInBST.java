/**
 * 	Given a Binary Search Tree (with all values unique) and two node values n1 and n2 (n1!=n2). Find the Lowest Common Ancestors of the two nodes in the BST.
	
	Example 1:
	Input:
	              5
	            /   \
	          4      6
	         /        \
	        3          7
	                    \
	                     8
	n1 = 7, n2 = 8
	Output: 7

	Example 2:
	Input:
	     2
	   /   \
	  1     3
	n1 = 1, n2 = 3
	Output: 2
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST11LowestCommonAncestorInBST {

    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a BST.
     *
     * Time Complexity: O(H) - where H is the height of the tree. In the worst case, this could be O(N) for a skewed tree.
     * Space Complexity: O(H) - due to the recursion stack. In the worst case, this could be O(N) for a skewed tree.
     *
     * @param root the root of the BST
     * @param n1 the value of the first node
     * @param n2 the value of the second node
     * @return the LCA node of n1 and n2
     */
    Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return root; // Return null if root is null
        }

        // If both n1 and n2 are smaller than root, then LCA lies in the left subtree
        if (root.data > n1 && root.data > n2) {
            return LCA(root.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in the right subtree
        if (root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        }

        // If neither of the above conditions is true, then root is the LCA
        return root;
    }
}
