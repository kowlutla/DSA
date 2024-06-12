/**
 * 	Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
	
	Example 1:
	Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	Output: [3,9,20,null,null,15,7]

	Example 2:
	Input: inorder = [-1], postorder = [-1]
	Output: [-1]
	 
	
	Constraints:
	1 <= inorder.length <= 3000
	postorder.length == inorder.length
	-3000 <= inorder[i], postorder[i] <= 3000
	inorder and postorder consist of unique values.
	Each value of postorder also appears in inorder.
	inorder is guaranteed to be the inorder traversal of the tree.
	postorder is guaranteed to be the postorder traversal of the tree.
	
	**** WITHOUT DUPLICATES ****
 */
package com.dsa.binary_tree;

import java.util.HashMap;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT39BinaryTreeFromInOrderPostOrderI {

    /**
     * Builds a binary tree from the given inorder and postorder traversal arrays.
     *
     * @param inorder The inorder traversal array.
     * @param postorder The postorder traversal array.
     * @return The root node of the constructed binary tree.
     *
     * Time Complexity: O(N) - Each node is processed once.
     * Space Complexity: O(N) - The space required for the hashmap and the recursive stack.
     */
    public Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int n = inorder.length;
        
        // Populate the hashmap with the indices of the inorder elements
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        // Start building the tree using a recursive helper method
        return buildTree(inorder, 0, n - 1, inMap, postorder, 0, n - 1);
    }

    /**
     * Helper method to recursively build the binary tree.
     *
     * @param inorder The inorder traversal array.
     * @param inStart The start index of the current subtree in the inorder array.
     * @param inEnd The end index of the current subtree in the inorder array.
     * @param inMap A hashmap mapping node values to their indices in the inorder array.
     * @param postorder The postorder traversal array.
     * @param postStart The start index of the current subtree in the postorder array.
     * @param postEnd The end index of the current subtree in the postorder array.
     * @return The root node of the constructed subtree.
     */
    private Node buildTree(int[] inorder, int inStart, int inEnd,
                           HashMap<Integer, Integer> inMap, int[] postorder, int postStart,
                           int postEnd) {

        // Base case: if the indices are out of range, return null
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The root value is the last element in the current postorder range
        Node root = new Node(postorder[postEnd]);

        // Find the index of the root value in the inorder array using the hashmap
        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTree(inorder, inStart, inRoot - 1, inMap, postorder,
                              postStart, postStart + numsLeft - 1);
        root.right = buildTree(inorder, inRoot + 1, inEnd, inMap, postorder,
                               postStart + numsLeft, postEnd - 1);
        return root;
    }
}
