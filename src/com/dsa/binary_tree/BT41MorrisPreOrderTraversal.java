/**
 * 	Given a Binary Tree, implement Morris Preorder Traversal and return the array containing its preorder sequence.

	Morris Preorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) without recursion or an external data structure. The algorithm should efficiently visit each node in the binary tree in preorder sequence, printing or processing the node values as it traverses, without using a stack or recursion.
 
 	Example 1:
	Input:Binary Tree: 4 2 5 3 -1 7 6 -1 9 -1 -1 8 -1 1
	Output: [4 2 3 9 1 5 7 6 8]
	Explanation: We traverse the binary tree in the order of Root, Left then Right recursively resulting in the following traversal:
	
	Example 2:
	Input:Binary Tree: 1 2 3 4 5 6 7 -1 -1 8 -1 -1 -1 9 10
	Output: [1 2 4 5 8 3 6 7 9 10]
	Explanation: We traverse the binary tree in the order of Root, Left then Right recursively resulting in the following traversal:

 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BT41MorrisPreOrderTraversal {

    /**
     * Performs Morris Preorder Traversal of the binary tree.
     * 
     * Time Complexity: O(N) where N is the number of nodes in the binary tree.
     * Each node is visited twice (once for establishing the thread and once for visiting).
     * 
     * Space Complexity: O(1) as no extra space is used apart from a few temporary variables.
     *
     * @param root The root node of the binary tree.
     * @return A list of integers representing the preorder traversal of the tree.
     */
    public List<Integer> getPreorder(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        Node current = root;
        Node prev;

        while (current != null) {
            if (current.left == null) {
                preOrder.add(current.data);
                current = current.right;
            } else {
                prev = current.left;
                // Find the rightmost node in the left subtree or the inorder predecessor of current
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    // Establish a temporary link from the inorder predecessor to current node
                    preOrder.add(current.data);
                    prev.right = current;
                    current = current.left;
                } else {
                    // Remove the temporary link
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return preOrder;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BT41MorrisPreOrderTraversal treeTraversal = new BT41MorrisPreOrderTraversal();
        List<Integer> preOrder = treeTraversal.getPreorder(root);

        // Print the preorder traversal
        System.out.println("Preorder Traversal: " + preOrder);
    }
}
