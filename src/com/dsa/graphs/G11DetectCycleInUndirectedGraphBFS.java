/**
 * 	Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, 
 	check whether it contains any cycle or not. Graph is in the form of adjacency list 
 	where adj[i] contains all the nodes ith node is having edge with.
	
	Example 1:
	Input:  
	V = 5, E = 5
	adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
	Output: 1
	Explanation: 
	1->2->3->4->1 is a cycle.

	Example 2:
	Input: 
	V = 4, E = 2
	adj = {{}, {2}, {1, 3}, {2}}
	Output: 0
	Explanation: 
	No cycle in the graph.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G11DetectCycleInUndirectedGraphBFS {

	// Function to check if a cycle exists in an undirected graph
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V]; // Array to track visited nodes
		// Iterate through each node in the graph
		for (int node = 0; node < V; node++) {
			if (!visited[node]) { // If the node has not been visited yet
				if (hasCycle(visited, adj, node)) { // Check if the node and its descendants form a cycle
					return true; // If a cycle is found, return true
				}
			}
		}
		return false; // If no cycle is found, return false
	}

	// Helper function to perform DFS traversal and detect cycles
	private static class Pair {
		int currentNode;
		int parentNode;

		public Pair(int currentNode, int parentNode) {
			this.currentNode = currentNode;
			this.parentNode = parentNode;
		}
	}

	private static boolean hasCycle(boolean[] visited,
			ArrayList<ArrayList<Integer>> adj, int source) {

		visited[source] = true; // Mark the current node as visited
		Queue<Pair> q = new LinkedList<>(); // Queue to perform BFS traversal
		q.add(new Pair(source, -1)); // Add the current node to the queue with its parent as -1

		while (!q.isEmpty()) {
			Pair node = q.poll(); // Retrieve and remove the front node from the queue
			int current = node.currentNode; // Current node
			int parent = node.parentNode; // Parent node

			for (int adjNode : adj.get(current)) { // Iterate through the adjacent nodes of the current node

				if (!visited[adjNode]) { // If the adjacent node has not been visited
					visited[adjNode] = true; // Mark the adjacent node as visited
					q.add(new Pair(adjNode, current)); // Add the adjacent node to the queue with its parent as the current node
				} else if (parent != adjNode) { // If the adjacent node is visited and is not the parent of the current node
					return true; // A cycle is detected, return true
				}
			}
		}
		return false; // If no cycle is detected, return false
	}
	
	public static void main(String[] args) {
		// Example graph represented as an adjacency list
		int V = 5; // Number of vertices
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		// Add edges to the graph
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 0);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		// Check if the graph contains a cycle
		boolean hasCycle = isCycle(V, adj);

		// Display the result
		if (hasCycle) {
			System.out.println("The graph contains a cycle.");
		} else {
			System.out.println("The graph does not contain a cycle.");
		}
	}

	// Helper method to add an edge to the adjacency list representation of the graph
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,
			int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}
