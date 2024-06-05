/**
 * 	Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.
	In zig zag traversal starting from the first level go from left to right for odd-numbered levels and right to left for even-numbered levels.
	
	Example 1:
	Input:
	        1
	      /   \
	     2    3
	    / \    /   \
	   4   5 6   7
	Output:
	1 3 2 4 5 6 7
	Explanation:
	For level 1 going left to right, we get traversal as {1}.
	For level 2 going right to left, we get traversal as {3,2}.
	For level 3 going left to right, we get traversal as {4,5,6,7}.
	Merging all this traversals in single array we get {1,3,2,4,5,6,7}
	
	Example 2:
	Input:
	           7
	        /     \
	       9      7
	     /  \      /   
	    8   8   6     
	   /  \
	  10  9 
	Output:
	7 7 9 8 8 6 9 10 
	Explanation:
	For level 1 going left to right, we get traversal as {7}.
	For level 2 going right to left, we get traversal as {7,9}.
	For level 3 going left to right, we get traversal as {8,8,6}.
	For level 4 going right to left, we get traversal as {9,10}.
	Merging all this traversals in single array we get {7,7,9,8,8,6,9,10}.
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class B18ZigZagTreeTraversal {

    /**
     * Performs a zigzag (spiral order) traversal on a binary tree and returns the values as a list.
     * In zigzag traversal, the order of nodes alternates between left-to-right and right-to-left at each level.
     *
     * Time Complexity: O(n), where n is the number of nodes in the binary tree.
     * Space Complexity: O(w), where w is the maximum width of the binary tree (due to the queue storage).
     *
     * @param root The root node of the binary tree.
     * @return A list containing the values of nodes in zigzag order.
     */
    public static List<Integer> zigZagTraversal(Node root) {
        // List to store the result of the traversal
        ArrayList<Integer> result = new ArrayList<>();
        // Queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);
        // Boolean flag to alternate the traversal order
        boolean isLeftToRight = true;

        // Perform level order traversal
        while (!q.isEmpty()) {
            // Number of nodes at the current level
            int size = q.size();
            // List to store the current level nodes
            ArrayList<Integer> currentLevel = new ArrayList<>();

            // Traverse nodes at the current level
            for (int i = 1; i <= size; i++) {
                // Remove the front node from the queue
                Node temp = q.poll();
                // Add the node's data to the current level list
                currentLevel.add(temp.data);

                // Add left child to the queue if it exists
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add right child to the queue if it exists
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            // If the current level needs to be added in reverse order
            if (!isLeftToRight) {
                Collections.reverse(currentLevel);
            }
            // Add the current level nodes to the result list
            result.addAll(currentLevel);
            // Toggle the traversal order for the next level
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }
}
