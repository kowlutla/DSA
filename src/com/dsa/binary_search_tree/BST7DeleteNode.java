/**
 * 	Given a Binary Search Tree and a node value X. Delete the node with the given value X from the BST. If no node with value x exists, then do not make any change. 
	
	Example 1:
	
	Input:
	      2
	    /   \
	   1     3
	X = 12
	Output: 1 2 3
	Explanation: In the given input there
	is no node with value 12 , so the tree
	will remain same.
	Example 2:
	
	Input:
	            1
	             \
	              2
	                \
	                 8 
	               /    \
	              5      11
	            /  \    /  \
	           4    7  9   12
	X = 9
	Output: 1 2 4 5 7 8 11 12
	Explanation: In the given input tree after
	deleting 9 will be
	             1
	              \
	               2
	                 \
	                  8
	                 /   \
	                5     11
	               /  \     \
	              4    7     12
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST7DeleteNode {

    /**
     * Deletes a node with the given key from the BST.
     * 
     * Time Complexity: O(H)
     * Space Complexity: O(H)
     *
     * @param root the root node of the BST
     * @param X the value to be deleted
     * @return the root node of the BST after deletion
     */
    public static Node deleteNode(Node root, int X) {
        if (root == null) {
            return root; // Return if the tree is empty
        }

        // Traverse the tree to find the node to be deleted
        if (root.data > X) {
            root.left = deleteNode(root.left, X);
        } else if (root.data < X) {
            root.right = deleteNode(root.right, X);
        } else {
            // Node to be deleted found

            // Case 1: Node has no left child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: Node has no right child
            else if (root.right == null) {
                return root.left;
            } 
            // Case 3: Node has both left and right children
            else {
                // Get the inorder successor (smallest in the right subtree)
                int successor = getNextGreater(root.right);
                root.data = successor; // Replace root's data with successor's data
                root.right = deleteNode(root.right, root.data); // Delete the inorder successor
            }
        }

        return root; // Return the root after deletion
    }

    /**
     * Finds the inorder successor of a given node.
     * 
     * Time Complexity: O(H)
     * Space Complexity: O(1)
     *
     * @param node the root node of the right subtree
     * @return the data of the inorder successor
     */
    private static int getNextGreater(Node node) {
        Node current = node;
        Node parent = null;

        // Find the leftmost leaf in the right subtree
        while (current != null) {
            parent = current;
            current = current.left;
        }

        return parent.data; // Return the data of the inorder successor
    }
}
