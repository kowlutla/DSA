/**
 * 	Given inorder and postorder traversals of a binary tree(having n nodes) in the arrays in[] and post[] respectively. The task is to construct a binary tree from these traversals.
	
	Example 1:
	Input:
	n = 8
	in[] = {4, 8, 2, 5, 1, 6, 3, 7}
	post[] = {8, 4, 5, 2, 6, 7, 3, 1}
	Output: 
	1 2 4 8 5 3 6 7
	Explanation: 
	For the given postorder and inorder traversal of tree the  resultant binary tree will be
	          1
	       /      \
	     2        3
	   /  \      /  \
	  4   5    6   7
	   \
	    8

	Example 2:
	Input:
	n = 5
	in[] = {9, 5, 2, 3, 4}
	post[] = {5, 9, 3, 4, 2}
	Output: 
	2 9 5 4 3
	Explanation:  
	The  resultant binary tree will be
	           2
	        /     \
	       9      4
	        \     /
	         5   3
	         
	    **** WITH DUPLICATES ****
 */
package com.dsa.binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT39BinaryTreeFromInOrderPostOrderII {

    /**
     * Builds a binary tree from the given inorder and postorder traversal arrays.
     *
     * @param in The inorder traversal array.
     * @param post The postorder traversal array.
     * @param n The number of nodes in the tree.
     * @return The root node of the constructed binary tree.
     *
     * Time Complexity: O(N) - Each node is processed once.
     * Space Complexity: O(N) - The space required for the hashmap and the recursive stack.
     */
    public Node buildTree(int[] in, int[] post, int n) {
        HashMap<Integer, Queue<Integer>> inMap = new HashMap<>();

        // Populate the hashmap with the indices of the inorder elements in reverse order
        for (int i = n - 1; i >= 0; i--) {
            Queue<Integer> q = inMap.get(in[i]);
            if (q == null) {
                q = new LinkedList<>();
            }
            q.add(i);
            inMap.put(in[i], q);
        }
        // Start building the tree using a recursive helper method
        return buildTree(in, 0, n - 1, inMap, post, 0, n - 1);
    }

    /**
     * Helper method to recursively build the binary tree.
     *
     * @param in The inorder traversal array.
     * @param inStart The start index of the current subtree in the inorder array.
     * @param inEnd The end index of the current subtree in the inorder array.
     * @param inMap A hashmap mapping node values to their indices in the inorder array.
     * @param post The postorder traversal array.
     * @param postStart The start index of the current subtree in the postorder array.
     * @param postEnd The end index of the current subtree in the postorder array.
     * @return The root node of the constructed subtree.
     */
    private Node buildTree(int[] in, int inStart, int inEnd,
                           HashMap<Integer, Queue<Integer>> inMap, int[] post, int postStart,
                           int postEnd) {

        // Base case: if the indices are out of range, return null
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The root value is the last element in the current postorder range
        Node root = new Node(post[postEnd]);

        // Find the index of the root value in the inorder array using the hashmap
        Queue<Integer> nodes = inMap.get(post[postEnd]);
        int inRoot = nodes.remove();
        int numsLeft = inRoot - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTree(in, inStart, inRoot - 1, inMap, post, postStart,
                              postStart + numsLeft - 1);
        root.right = buildTree(in, inRoot + 1, inEnd, inMap, post,
                               postStart + numsLeft, postEnd - 1);
        return root;
    }
}
