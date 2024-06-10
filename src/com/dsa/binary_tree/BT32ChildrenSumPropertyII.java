/**
 * 	Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property. The Children Sum Property in a binary tree states that for every node, the sum of its children's values (if they exist) should be equal to the node's value. If a child is missing, it is considered as having a value of 0.

	Note:
	The node values can be increased by any positive integer any number of times, but decrementing any node value is not allowed.
	A value for a NULL node can be assumed as 0.
	We cannot change the structure of the given binary tree.

	Examples
	Example 1:
	Input:Binary Tree: 2 35 10 2 3 5 2
	Output: Binary Tree: 45 35 10 30 5 8 2 (Can be any but should hold the property)
	
	Explanation: We cannot decrement the value of the node but only increment. There are many different ways to do this but we have to ensure that we are only increasing the values of the nodes in such a way that its value is equal to the sum of its left and right children.

	Example 2:
	Input:Binary Tree: 50 7 2 3 5 1 30
	Output : Binary Tree: 50 55 5 86 1 31 30 (Can be any but should hold the property)
	
	Explanation: We modify the tree in such a way that the value of each node becomes the value of its left and right children. If a node is a left or right child and its parent is of a greater value, since we cannot decrease the value of the parent, we increase the value of the children nodes so that the Binary Tree follows the children sum property.
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT32ChildrenSumPropertyII {

    /**
     * Modifies the given binary tree so that it satisfies the children sum property.
     * The children sum property states that for every node, the node's value must be
     * equal to the sum of the values of its left and right children.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(h) - where h is the height of the binary tree.
     *
     * @param root The root node of the binary tree.
     */
    public void changeTree(Node root) {
        // Base case: if the root is null, return
        if (root == null) {
            return;
        }

        // Initialize sum to store the sum of the left and right children
        int sum = 0;

        // If the left child exists, add its data to the sum
        if (root.left != null) {
            sum += root.left.data;
        }

        // If the right child exists, add its data to the sum
        if (root.right != null) {
            sum += root.right.data;
        }

        // If the sum of the children is greater than or equal to the root's data,
        // set the root's data to the sum
        if (sum >= root.data) {
            root.data = sum;
        } else {
            // Otherwise, set the children's data to the root's data
            if (root.left != null) {
                root.left.data = root.data;
            }

            if (root.right != null) {
                root.right.data = root.data;
            }
        }

        // Recursively call changeTree on the left and right children
        changeTree(root.left);
        changeTree(root.right);

        // Recalculate the total sum of the left and right children's data
        int total = 0;
        if (root.left != null) {
            total += root.left.data;
        }

        if (root.right != null) {
            total += root.right.data;
        }

        // If both children exist, set the root's data to the total sum of the children's data
        if (root.left != null && root.right != null) {
            root.data = total;
        }
    }
}
