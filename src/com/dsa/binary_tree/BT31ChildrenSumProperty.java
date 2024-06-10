/**
 * 	Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.
	
	For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.
	
	Example 1:
	Input:
	Binary tree
	       35
	      /   \
	     20  15
	    /  \  /  \
	   15 5 10 5
	Output: 
	1
	Explanation: 
	Here, every node is sum of its left and right child.

	Example 2:
	Input:
	Binary tree
	       1
	     /   \
	    4    3
	   /  
	  5    
	Output: 
	0
	Explanation: 
	Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
 */
package com.dsa.binary_tree;

/**
 * @author KowlutlaSwamy
 *
 */
public class BT31ChildrenSumProperty {

    /**
     * Checks if the given binary tree satisfies the children sum property.
     *
     * In a tree, the children sum property means that for every node,
     * the value of the node must be equal to the sum of values of its left and right children.
     *
     * Time Complexity: O(N) - where N is the number of nodes in the binary tree.
     * Space Complexity: O(h) - where h is the height of the binary tree.
     *
     * @param node The root node of the binary tree.
     * @return 1 if the tree satisfies the children sum property, otherwise 0.
     */
    public static int isSumProperty(Node node) {
        // Base case: if the node is null or it's a leaf node, return 1
        if (node == null || (node.left == null && node.right == null)) {
            return 1;
        }

        int leftData = 0;
        int rightData = 0;

        // If the left child exists, get its data
        if (node.left != null) {
            leftData = node.left.data;
        }

        // If the right child exists, get its data
        if (node.right != null) {
            rightData = node.right.data;
        }

        // Check if the node's data is equal to the sum of its children's data
        // and recursively check the left and right subtrees
        if (node.data == leftData + rightData && isSumProperty(node.left) == 1 && isSumProperty(node.right) == 1) {
            return 1;
        }

        // If the node does not satisfy the children sum property, return 0
        return 0;
    }
}
