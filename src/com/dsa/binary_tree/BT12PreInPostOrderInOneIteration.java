/**
 * 	Given the root of a Binary Tree, return the preorder, inorder and postorder traversal sequence of the given tree by making just one traversal.
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT12PreInPostOrderInOneIteration {

    /**
     * A utility class to hold a node and its visitation count.
     */
    private static class Pair {
        Node node;
        int count;

        public Pair(Node node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    /**
     * Performs pre-order, in-order, and post-order traversal of the binary tree in a single iteration.
     *
     * @param node The root node of the binary tree.
     * @return A list of three lists, where each list contains the node values in pre-order, in-order, and post-order traversal respectively.
     */
    public static List<List<Integer>> preInPostTraversal(Node node) {
        // Lists to store the traversal results
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        // Stack to manage the traversal process
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));

        // Iterate while there are nodes to process
        while (!stack.isEmpty()) {

            Pair current = stack.pop();
            int currentCount = current.count;
            Node currentNode = current.node;

            // Process the node based on the current count value
            if (currentCount == 1) {
                // Pre-order position: Process the node before its children
                stack.push(new Pair(currentNode, currentCount + 1));
                preOrder.add(currentNode.data);

                // Add the left child to the stack if it exists
                if (currentNode.left != null) {
                    stack.push(new Pair(currentNode.left, 1));
                }

            } else if (currentCount == 2) {
                // In-order position: Process the node after its left child
                inOrder.add(currentNode.data);
                stack.push(new Pair(currentNode, currentCount + 1));

                // Add the right child to the stack if it exists
                if (currentNode.right != null) {
                    stack.push(new Pair(currentNode.right, 1));
                }

            } else {
                // Post-order position: Process the node after its children
                postOrder.add(currentNode.data);
            }
        }

        // Collect the traversal results into a single list
        List<List<Integer>> result = new ArrayList<>();
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);
        return result;
    }

    // Main function to test the traversal methods
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the pre-order, in-order, and post-order traversals
        List<Integer> pre, in, post;
        List<List<Integer>> traversals = preInPostTraversal(root);

        // Extracting the traversals from the result
        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        System.out.println(pre);

        System.out.print("Inorder traversal: ");
        System.out.println(in);

        System.out.print("Postorder traversal: ");
        System.out.println(post);
    }
}