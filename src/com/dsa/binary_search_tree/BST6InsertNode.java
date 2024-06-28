/**
 * 	Given a BST and a key k. If k is not present in the BST, Insert a new Node with a value equal to k into the BST. If k is already present in the BST, don't modify the BST. Return the root of the modified BST after inserting k. 
	
	Note: The generated output contains the inorder traversal of the modified tree.
	
	Examples :
	Input: k = 4
	     2
	   /   \   
	  1     3
	Output: 1 2 3 4
	Explanation: After inserting the node 4 Inorder traversal will be 1 2 3 4.
	
	Input: k = 4
	        2
	      /   \
	     1     3
	             \
	              6
	Output: 1 2 3 4 6
	Explanation: After inserting the node 4 Inorder traversal of the above tree will be 1 2 3 4 6.
 */
package com.dsa.binary_search_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST6InsertNode {

    /**
     * Recursively inserts a node with the given key into the BST.
     * 
     * Time Complexity: O(H)
     * The time complexity is O(H), where H is the height of the tree. In the worst case, H can be N (for a skewed tree).
     * 
     * Space Complexity: O(H)
     * The space complexity is O(H) due to the recursion stack. In the worst case, H can be N (for a skewed tree).
     *
     * @param root the root node of the BST
     * @param key the value to be inserted
     * @return the root node of the BST after insertion
     */
    public static Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key); // Create a new node if the current node is null
        }
        if (root.data == key) {
            return root; // If the key is already present, return the root
        }

        // Traverse to the right subtree if the key is greater than the current node's data
        if (root.data < key) {
            root.right = insertRec(root.right, key);
        } else {
            // Traverse to the left subtree if the key is less than the current node's data
            root.left = insertRec(root.left, key);
        }

        return root; // Return the root after insertion
    }

    /**
     * Iteratively inserts a node with the given key into the BST.
     * 
     * Time Complexity: O(H)
     * The time complexity is O(H), where H is the height of the tree. In the worst case, H can be N (for a skewed tree).
     * 
     * Space Complexity: O(1)
     * The space complexity is O(1) as no additional space is used except for a few variables.
     *
     * @param root the root node of the BST
     * @param key the value to be inserted
     * @return the root node of the BST after insertion
     */
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key); // Create a new node if the tree is empty
        }
        Node current = root; // Start from the root
        Node parent = null; // To keep track of the parent node

        // Traverse the tree to find the correct position for the new node
        while (current != null) {
            if (current.data == key) {
                return root; // If the key is already present, return the root
            } else if (current.data < key) {
                parent = current;
                current = current.right; // Move to the right subtree
            } else {
                parent = current;
                current = current.left; // Move to the left subtree
            }
        }

        // Insert the new node as a child of the parent node
        if (parent.data > key) {
            parent.left = new Node(key); // Insert as the left child
        } else {
            parent.right = new Node(key); // Insert as the right child
        }

        return root; // Return the root after insertion
    }
}
