/**
 * 	Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument. If no left view is possible, return an empty tree.
	
	Left view of following tree is 1 2 4 8.
	
	          1
	       /     \
	     2        3
	   /     \    /    \
	  4     5   6    7
	   \
	     8   
	
	Example 1:
	Input:
	   1
	 /  \
	3    2
	Output: 1 3
	
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
public class BT23LeftViewOfBinaryTree {
	

    /**
     * Computes the left view of a binary tree using level order traversal.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(N) - for the queue used in level order traversal.
     *
     * @param root The root node of the binary tree.
     * @return A List containing the left view of the binary tree.
     */
    public static List<Integer> leftView1(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        
        if (root == null) {
            return nodes; // Return an empty list if the tree is empty
        }

        // Use a queue to perform level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at the current level
            
            // Add the first node of the current level to the result list
            nodes.add(q.peek().data);
            
            // Process all nodes at the current level
            for (int i = 1; i <= size; i++) {
                Node temp = q.poll();
                
                // Add the left child to the queue if it exists
                if (temp.left != null) {
                    q.add(temp.left);
                }
                
                // Add the right child to the queue if it exists
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return nodes; // Return the list containing the left view nodes
    }

    /**
     * Computes the left view of a binary tree.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(H) - where H is the height of the tree, due to the recursion stack.
     *
     * @param root The root node of the binary tree.
     * @return A List containing the left view of the binary tree.
     */
    public static List<Integer> leftView2(Node root) {
        ArrayList<Integer> leftViewNodes = new ArrayList<>();
        leftView(root, leftViewNodes, 1); // Start from level 1
        return leftViewNodes;
    }

    /**
     * Helper method to compute the left view recursively.
     * 
     * @param root The current node being processed.
     * @param leftViewNodes The list containing nodes in the left view.
     * @param level The current level in the tree.
     */
    private static void leftView(Node root, ArrayList<Integer> leftViewNodes, int level) {
        if (root == null) {
            return;
        }

        // If this is the first node of this level, add it to the list
        if (level > leftViewNodes.size()) {
            leftViewNodes.add(root.data);
        }

        // Recurse for the left subtree first, then for the right subtree
        leftView(root.left, leftViewNodes, level + 1);
        leftView(root.right, leftViewNodes, level + 1);
    }

}
