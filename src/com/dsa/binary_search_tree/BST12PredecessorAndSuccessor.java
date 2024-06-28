/**
 * 	There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.
	
	Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 
	
	Example 1:
	Input:
	      8
	    /   \
	   1     9
	    \     \
	     4    10
	    /
	   3
	key = 8 
	Output: 4 9
	Explanation: 
	In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.

	Example 2:
	Input:
	        10
	      /   \
	     2    11
	   /  \ 
	  1    5
	      /  \
	     3    6
	      \
	       4
	key = 11
	Output: 10 -1
	Explanation:In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST12PredecessorAndSuccessor {

    /**
     * Finds the predecessor and successor of a given key in the BST.
     *
     * Time Complexity: O(H) - where H is the height of the tree. 
     * In the worst case, this could be O(N) for a skewed tree.
     * Space Complexity: O(1) - no additional space is used except for the variables.
     *
     * @param root the root of the BST
     * @param pre an array of size 1 to store the predecessor node
     * @param suc an array of size 1 to store the successor node
     * @param key the value whose predecessor and successor need to be found
     */
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // Initialize current node to root
        Node current = root;

        // Find successor
        while (current != null) {
            if (current.data > key) {
                suc[0] = current; // Update successor
                current = current.left; // Move to the left child
            } else {
                current = current.right; // Move to the right child
            }
        }

        // Reinitialize current node to root
        current = root;

        // Find predecessor
        while (current != null) {
            if (current.data < key) {
                pre[0] = current; // Update predecessor
                current = current.right; // Move to the right child
            } else {
                current = current.left; // Move to the left child
            }
        }
    }
}
