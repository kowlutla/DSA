/**
 * 
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT24RightViewOfBinaryTree {

    /**
     * Computes the right view of a binary tree using level order traversal.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - for the queue used in level order traversal.
     *
     * @param node The root node of the binary tree.
     * @return A List containing the right view of the binary tree.
     */
    public static List<Integer> rightView1(Node node) {
        ArrayList<Integer> rightView = new ArrayList<>();
        
        // Return empty list if the tree is empty
        if (node == null) {
            return rightView;
        }

        // Initialize a queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        // Perform level order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            Node current = null;

            // Process all nodes at the current level
            for (int i = 1; i <= size; i++) {
                current = q.poll();

                // Add the left child to the queue
                if (current.left != null) {
                    q.add(current.left);
                }

                // Add the right child to the queue
                if (current.right != null) {
                    q.add(current.right);
                }
            }

            // Add the last node of the current level to the right view
            rightView.add(current.data);
        }

        return rightView;
    }

    /**
     * Computes the right view of a binary tree using depth first traversal.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(H) - where H is the height of the binary tree (for the recursive call stack).
     *
     * @param node The root node of the binary tree.
     * @return A List containing the right view of the binary tree.
     */
    public static List<Integer> rightView2(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        int level = 1;

        // Start the recursive right view traversal
        rightView(node, result, level);
        return result;
    }

    /**
     * Helper method for right view using depth first traversal.
     * 
     * @param node   The current node being processed.
     * @param result The list to store the right view nodes.
     * @param level  The current level in the binary tree.
     */
    private static void rightView(Node node, ArrayList<Integer> result, int level) {
        // Return if the current node is null
        if (node == null) {
            return;
        }

        // Add the node to the result if it's the first node at the current level
        if (level > result.size()) {
            result.add(node.data);
        }

        // Recursively process the right subtree first, then the left subtree
        rightView(node.right, result, level + 1);
        rightView(node.left, result, level + 1);
    }
}
