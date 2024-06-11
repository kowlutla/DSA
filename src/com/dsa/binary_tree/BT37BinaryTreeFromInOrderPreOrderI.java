/**
 * 	Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
	
	Example 1:
	Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	Output: [3,9,20,null,null,15,7]

	Example 2:
	Input: preorder = [-1], inorder = [-1]
	Output: [-1]
	
	Constraints:
	
	1 <= preorder.length <= 3000
	inorder.length == preorder.length
	-3000 <= preorder[i], inorder[i] <= 3000
	preorder and inorder consist of unique values.
	Each value of inorder also appears in preorder.
	preorder is guaranteed to be the preorder traversal of the tree.
	inorder is guaranteed to be the inorder traversal of the tree.
	
	*** WITHOUT DUPLICATE VALUES ***
 */
package com.dsa.binary_tree;

import java.util.HashMap;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT37BinaryTreeFromInOrderPreOrderI {

    /**
     * Builds a binary tree from the given preorder and inorder traversal arrays.
     *
     * @param preorder The preorder traversal array.
     * @param inorder The inorder traversal array.
     * @return The root node of the constructed binary tree.
     *
     * Time Complexity: O(N) - Each node is processed once.
     * Space Complexity: O(N) - The space required for the hashmap and the recursive stack.
     */
    public Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        int n = preorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, inMap);
    }

    /**
     * Helper method to recursively build the binary tree.
     *
     * @param preorder The preorder traversal array.
     * @param preOrderStartIndex The start index of the current subtree in the preorder array.
     * @param preOrderEndIndex The end index of the current subtree in the preorder array.
     * @param inorder The inorder traversal array.
     * @param inOrderStartIndex The start index of the current subtree in the inorder array.
     * @param inOrderEndIndex The end index of the current subtree in the inorder array.
     * @param inOrderMap A hashmap mapping node values to their indices in the inorder array.
     * @return The root node of the constructed subtree.
     */
    private Node buildTree(int[] preorder, int preOrderStartIndex, int preOrderEndIndex,
                           int[] inorder, int inOrderStartIndex, int inOrderEndIndex,
                           HashMap<Integer, Integer> inOrderMap) {

        // Base case: if the indices are out of range, return null
        if (preOrderStartIndex > preOrderEndIndex || inOrderStartIndex > inOrderEndIndex) {
            return null;
        }

        // The root value is the first element in the current preorder range
        int value = preorder[preOrderStartIndex];
        Node root = new Node(value);

        // Find the index of the root value in the inorder array
        int rootIndexInInOrder = inOrderMap.get(value);
        
        // Number of nodes in the left subtree
        int numLeftOnLeftSubTree = rootIndexInInOrder - inOrderStartIndex;

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preOrderStartIndex + 1, preOrderStartIndex + numLeftOnLeftSubTree,
                              inorder, inOrderStartIndex, rootIndexInInOrder - 1, inOrderMap);
        root.right = buildTree(preorder, preOrderStartIndex + numLeftOnLeftSubTree + 1, preOrderEndIndex,
                               inorder, rootIndexInInOrder + 1, inOrderEndIndex, inOrderMap);

        return root;
    }
}
