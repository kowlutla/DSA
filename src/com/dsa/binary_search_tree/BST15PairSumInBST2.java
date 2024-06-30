/**
 * 	Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 
	
	Example 1:
	Input:
	        2
	      /   \
	     1     3
	sum = 5
	Output: 1 
	Explanation: 
	Nodes with value 2 and 3 sum up to 5.

	Example 2:
	Input:
	           6
	          /    
	         5     
	        /
	       3 
	     /  \
	    1    4
	sum = 2
	Output: 0 
	Explanation: 
	There's no pair that sums up to 2.
 */
package com.dsa.binary_search_tree;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST15PairSumInBST2 {

    /**
     * Inner class to create an iterator for the BST.
     * The iterator can either traverse in normal (in-order) or reverse (reverse in-order) order.
     */
    private class BSTIterator {
        private Stack<Node> stack;
        boolean isReverse;

        /**
         * Constructor to initialize the iterator.
         * @param root the root of the BST
         * @param isReverse flag to indicate the order of traversal
         */
        public BSTIterator(Node root, boolean isReverse) {
            stack = new Stack<Node>();
            this.isReverse = isReverse;
            pushAll(root);
        }

        /**
         * Helper method to push all nodes to the stack according to the traversal order.
         * @param root the current node
         */
        private void pushAll(Node root) {
            if (isReverse) { // Push nodes for reverse in-order traversal
                Node current = root;
                while (current != null) {
                    stack.push(current);
                    current = current.right;
                }
            } else { // Push nodes for in-order traversal
                Node current = root;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

        /**
         * Returns the next element in the iteration.
         * Acts as prev() if isReverse is true.
         * @return the next element
         */
        public int next() {
            if (hasNext()) {
                Node top = stack.pop();
                if (isReverse) {
                    pushAll(top.left);
                } else {
                    pushAll(top.right);
                }
                return top.data;
            }
            return -1; // Return -1 if there are no more elements
        }

        /**
         * Checks if there are more elements in the iteration.
         * Acts as hasPrevious() if isReverse is true.
         * @return true if there are more elements, otherwise false
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    /**
     * Method to check if there exists a pair with the given target sum in the BST using two BST iterators.
     * @param root the root of the BST
     * @param target the target sum to find
     * @return 1 if a pair is found, otherwise 0
     */
    public int isPairPresent(Node root, int target) {
        BSTIterator it1 = new BSTIterator(root, false); // Iterator for in-order traversal
        BSTIterator it2 = new BSTIterator(root, true); // Iterator for reverse in-order traversal

        int left = it1.next();
        int right = it2.next();

        while (left < right) { // While the left pointer is less than the right pointer
            if (left + right == target) { // If the sum of the two pointers matches the target
                return 1;
            } else if (left + right < target) { // If the sum is less than the target, move the left pointer to the right
                left = it1.next();
            } else { // If the sum is greater than the target, move the right pointer to the left
                right = it2.next();
            }
        }

        return 0; // Return 0 if no pair is found
    }

}
