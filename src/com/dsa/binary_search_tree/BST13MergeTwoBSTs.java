/**
 * 	Given two BSTs, return elements of both BSTs in sorted form.
	
	Example 1:
	Input:
	BST1:
	       5
	     /   \
	    3     6
	   / \
	  2   4  
	BST2:
	        2
	      /   \
	     1     3
	            \
	             7
	            /
	           6
	Output: 1 2 2 3 3 4 5 6 6 7
	Explanation: 
	After merging and sorting the
	two BST we get 1 2 2 3 3 4 5 6 6 7.

	Example 2:
	Input:
	BST1:
	       12
	     /   
	    9
	   / \    
	  6   11
	BST2:
	      8
	    /  \
	   5    10
	  /
	 2
	Output: 2 5 6 8 9 10 11 12
	Explanation: 
	After merging and sorting the
	two BST we get 2 5 6 8 9 10 11 12.
 */
package com.dsa.binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class BST13MergeTwoBSTs {

    /**
     * Merges two BSTs by performing in-order traversal and then merging two sorted lists.
     * Time Complexity: O(m + n) where m and n are the number of nodes in the first and second BST respectively.
     * Space Complexity: O(m + n) for storing the in-order traversal of both BSTs.
     *
     * @param root1 the root of the first BST
     * @param root2 the root of the second BST
     * @return a list of integers containing the merged values of both BSTs in sorted order
     */
    public List<Integer> merge1(Node root1, Node root2) {
        List<Integer> inorder1 = new LinkedList<>(); // List to store in-order traversal of first BST
        inOrder(root1, inorder1); // Perform in-order traversal on the first BST
        List<Integer> inorder2 = new LinkedList<>(); // List to store in-order traversal of second BST
        inOrder(root2, inorder2); // Perform in-order traversal on the second BST

        List<Integer> result = new ArrayList<>(inorder1.size() + inorder2.size()); // Result list to store merged values

        int index1 = 0, index2 = 0; // Pointers for inorder1 and inorder2

        // Merge the two sorted lists
        while (index1 < inorder1.size() && index2 < inorder2.size()) {
            if (inorder1.get(index1) <= inorder2.get(index2)) {
                result.add(inorder1.get(index1)); // Add smaller element to the result
                index1++; // Move pointer of inorder1
            } else {
                result.add(inorder2.get(index2)); // Add smaller element to the result
                index2++; // Move pointer of inorder2
            }
        }

        // Add remaining elements from the first list
        while (index1 < inorder1.size()) {
            result.add(inorder1.get(index1));
            index1++;
        }

        // Add remaining elements from the second list
        while (index2 < inorder2.size()) {
            result.add(inorder2.get(index2));
            index2++;
        }

        return result; // Return merged list
    }

    /**
     * Helper method to perform in-order traversal and store the elements in a list.
     *
     * @param root the root of the BST
     * @param list the list to store the in-order traversal elements
     */
    private void inOrder(Node root, List<Integer> list) {
        if (root == null) { // Base case: if the node is null, return
            return;
        }

        inOrder(root.left, list); // Recursively traverse the left subtree
        list.add(root.data); // Add the root data to the list
        inOrder(root.right, list); // Recursively traverse the right subtree
    }

    /**
     * Merges two BSTs using an iterative approach with stacks.
     * Time Complexity: O(m + n) where m and n are the number of nodes in the first and second BST respectively.
     * Space Complexity: O(m + n) for storing the elements in the result list.
     *
     * @param root1 the root of the first BST
     * @param root2 the root of the second BST
     * @return a list of integers containing the merged values of both BSTs in sorted order
     */
    public List<Integer> merge2(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>(); // Stack for in-order traversal of first BST
        Stack<Node> stack2 = new Stack<>(); // Stack for in-order traversal of second BST

        Node current1 = root1; // Pointer to traverse the first BST
        Node current2 = root2; // Pointer to traverse the second BST

        List<Integer> result = new LinkedList<>(); // Result list to store merged values

        // Traverse both BSTs in-order using stacks
        while (current1 != null || current2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {

            // Push all left nodes of first BST to stack1
            while (current1 != null) {
                stack1.push(current1);
                current1 = current1.left;
            }

            // Push all left nodes of second BST to stack2
            while (current2 != null) {
                stack2.push(current2);
                current2 = current2.left;
            }

            // Compare top elements of both stacks and add the smaller one to the result
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().data <= stack2.peek().data)) {
                result.add(stack1.peek().data); // Add top element of stack1 to result
                current1 = stack1.peek().right; // Move to the right subtree
                stack1.pop(); // Pop the top element
            } else {
                result.add(stack2.peek().data); // Add top element of stack2 to result
                current2 = stack2.peek().right; // Move to the right subtree
                stack2.pop(); // Pop the top element
            }
        }

        return result; // Return merged list
    }

    /**
     * Merges two BSTs by performing level-order traversal (BFS) on both BSTs, combining the results, and sorting them.
     * Time Complexity: O((m + n) log (m + n)) due to sorting at the end.
     * Space Complexity: O(m + n) for storing the elements of both BSTs.
     *
     * @param root1 the root of the first BST
     * @param root2 the root of the second BST
     * @return a list of integers containing the merged values of both BSTs in sorted order
     */
    public List<Integer> merge3(Node root1, Node root2) {
        List<Integer> a = new ArrayList<>(); // List to store elements of the first BST

        if (root1 != null) {
            Queue<Node> q1 = new LinkedList<>(); // Queue for level-order traversal
            q1.add(root1); // Start with the root

            // Perform level-order traversal on the first BST
            while (!q1.isEmpty()) {
                Node node1 = q1.poll(); // Dequeue the front node
                a.add(node1.data); // Add the node's data to the list

                if (node1.left != null) {
                    q1.add(node1.left); // Enqueue left child
                }

                if (node1.right != null) {
                    q1.add(node1.right); // Enqueue right child
                }
            }
        }

        List<Integer> b = new ArrayList<>(); // List to store elements of the second BST

        if (root2 != null) {
            Queue<Node> q2 = new LinkedList<>(); // Queue for level-order traversal
            q2.add(root2); // Start with the root

            // Perform level-order traversal on the second BST
            while (!q2.isEmpty()) {
                Node node2 = q2.poll(); // Dequeue the front node
                b.add(node2.data); // Add the node's data to the list

                if (node2.left != null) {
                    q2.add(node2.left); // Enqueue left child
                }

                if (node2.right != null) {
                    q2.add(node2.right); // Enqueue right child
                }
            }
        }

        a.addAll(b); // Combine the elements of both lists
        Collections.sort(a); // Sort the combined list

        return a; // Return the sorted list
    }
}
