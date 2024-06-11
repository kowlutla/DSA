/**
 * 	Given 2 Arrays of Inorder and preorder traversal. The tree can contain duplicate elements. Construct a tree and print the Postorder traversal. 
	
	Example 1:
	Input:
	N = 4
	inorder[] = {1 6 8 7}
	preorder[] = {1 6 7 8}
	Output: 8 7 6 1

	Example 2:
	Input:
	N = 6
	inorder[] = {3 1 4 0 5 2}
	preorder[] = {0 1 3 4 2 5}
	Output: 3 4 1 5 2 0
	Explanation: The tree will look like
	       0
	    /     \
	   1       2
	 /   \    /
	3    4   5
	
	*** WITH DUPLICATE VALUES ***
 */
package com.dsa.binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT38BinaryTreeFromInOrderPreOrderII {

    /**
     * Builds a binary tree from the given inorder and preorder traversal arrays.
     *
     * @param inOrder The inorder traversal array.
     * @param preOrder The preorder traversal array.
     * @param n The number of nodes in the tree.
     * @return The root node of the constructed binary tree.
     *
     * Time Complexity: O(N) - Each node is processed once.
     * Space Complexity: O(N) - The space required for the hashmap, the queues, and the recursive stack.
     */
    public static Node buildTree(int[] inOrder, int[] preOrder, int n) {
        // Create a hashmap to store the indices of the nodes in the inorder array
        HashMap<Integer, Queue<Integer>> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            Queue<Integer> q = inMap.get(inOrder[i]);
            if (q == null) {
                q = new LinkedList<>();
            }
            q.add(i);
            inMap.put(inOrder[i], q);
        }

        // Build the tree using a recursive helper method
        return buildTree(preOrder, 0, n - 1, inOrder, 0, n - 1, inMap);
    }

    /**
     * Helper method to recursively build the binary tree.
     *
     * @param preOrder The preorder traversal array.
     * @param preStart The start index of the current subtree in the preorder array.
     * @param preEnd The end index of the current subtree in the preorder array.
     * @param inOrder The inorder traversal array.
     * @param inStart The start index of the current subtree in the inorder array.
     * @param inEnd The end index of the current subtree in the inorder array.
     * @param inMap A hashmap mapping node values to their indices in the inorder array.
     * @return The root node of the constructed subtree.
     */
    private static Node buildTree(int[] preOrder, int preStart, int preEnd,
                                  int[] inOrder, int inStart, int inEnd,
                                  HashMap<Integer, Queue<Integer>> inMap) {

        // Base case: if the indices are out of range, return null
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        // The root value is the first element in the current preorder range
        Node root = new Node(preOrder[preStart]);

        // Find the index of the root value in the inorder array using the hashmap
        Queue<Integer> nodes = inMap.get(root.data);
        int inRoot = nodes.remove();
        int numLeft = inRoot - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTree(preOrder, preStart + 1, preStart + numLeft,
                              inOrder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preOrder, preStart + numLeft + 1, preEnd,
                               inOrder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
