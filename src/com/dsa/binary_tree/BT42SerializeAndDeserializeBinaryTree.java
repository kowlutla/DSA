/**
 * 	Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions
	
	serialize() : stores the tree into an array a and returns the array.
	deSerialize() : deserializes the array to the tree and returns the root of the tree.
	Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
	
	Example 1:
	
	Input:
	      1
	    /   \
	   2     3
	Output: 
	2 1 3
	Example 2:
	
	Input:
	         10
	       /    \
	      20    30
	    /   \
	   40  60
	Output: 
	40 20 60 10 30
 */
package com.dsa.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT42SerializeAndDeserializeBinaryTree {

    /**
     * Function to serialize a tree and return a list containing nodes of the tree.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the binary tree. 
     * Each node is visited once.
     * 
     * Space Complexity: O(N) for storing the serialized list and queue for level order traversal.
     *
     * @param root The root node of the binary tree.
     * @return A list of integers representing the level order traversal of the tree.
     */
    public List<Integer> serialize(Node root) {
        ArrayList<Integer> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        
        // Queue to facilitate level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            
            // If the current node is null, add -1 to the list to signify a null node
            if (current == null) {
                levelOrder.add(-1);
            } else {
                // Add the current node's data to the list
                levelOrder.add(current.data);
                // Add left and right children to the queue (even if they are null)
                q.add(current.left);
                q.add(current.right);
            }
        }
        return levelOrder;
    }

    /**
     * Function to deserialize a list and construct the tree.
     * 
     * Time Complexity: O(N), where N is the number of elements in the list. 
     * Each element is processed once.
     * 
     * Space Complexity: O(N) for storing the queue used in reconstruction.
     *
     * @param A The list of integers representing the serialized binary tree.
     * @return The root node of the deserialized binary tree.
     */
    public Node deSerialize(List<Integer> A) {
        if (A.isEmpty()) {
            return null;
        }

        // Create the root node from the first element of the list
        Node root = new Node(A.get(0));
        // Queue to facilitate level-order reconstruction
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int index = 1; index < A.size(); index++) {
            // Process nodes in the queue to assign their children
            Node parent = q.poll();
            
            // Process left child
            if (A.get(index) != -1) {
                Node leftChild = new Node(A.get(index));
                parent.left = leftChild;
                q.add(leftChild);
            }
            index++;
            
            // Ensure we haven't reached the end of the list before processing right child
            if (index < A.size() && A.get(index) != -1) {
                Node rightChild = new Node(A.get(index));
                parent.right = rightChild;
                q.add(rightChild);
            }
        }
        return root;
    }
    
    // Definition for the binary tree node
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Main method to test serialization and deserialization
    public static void main(String[] args) {
        BT42SerializeAndDeserializeBinaryTree tree = new BT42SerializeAndDeserializeBinaryTree();
        
        // Constructing a sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        // Serialize the tree
        List<Integer> serializedTree = tree.serialize(root);
        System.out.println("Serialized tree: " + serializedTree);
        
        // Deserialize the list back to tree
        Node deserializedRoot = tree.deSerialize(serializedTree);
        
        // Serialize again to verify
        List<Integer> verifySerializedTree = tree.serialize(deserializedRoot);
        System.out.println("Deserialized tree (serialized again for verification): " + verifySerializedTree);
    }
}
