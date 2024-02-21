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
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class G12DetectCycleInUndirectedGraphDFS {

    /**
     * Detects if there is a cycle in an undirected graph using Depth First Search (DFS).
     * 
     * Time Complexity: O(V + E), where V is the number of vertices (nodes) and E is the number of edges.
     * Space Complexity: O(V) for the visited array and O(V) for the recursive call stack space during DFS traversal.
     * 
     * @param V     The number of vertices in the graph.
     * @param adj   The adjacency list representation of the graph.
     * @return      True if the graph contains a cycle, otherwise false.
     */
    public static boolean detectCycle(int V, List<List<Integer>> adj) {
        // Array to track visited nodes during DFS traversal
        boolean[] visited = new boolean[V];

        // Iterate through all nodes in the graph
        for (int node = 0; node < V; node++) {
            // If the current node is not visited yet, check for cycle starting from this node
            if (!visited[node]) {
                if (hasCycle(visited, adj, node, -1)) { // Call helper method to perform DFS traversal and check for cycle
                    return true; // If cycle is detected, return true
                }
            }
        }
        return false; // If no cycle is detected after traversing all nodes, return false
    }

    /**
     * Helper method to perform DFS traversal and detect cycles in the graph.
     * 
     * Time Complexity: O(E), where E is the number of edges in the adjacency list of the current node.
     * Space Complexity: O(V) for the visited array and O(V) for the recursive call stack space during DFS traversal.
     * 
     * @param visited   An array to track visited nodes during traversal.
     * @param adj       The adjacency list representation of the graph.
     * @param current   The current node being visited.
     * @param parent    The parent node of the current node.
     * @return          True if a cycle is detected, otherwise false.
     */
    private static boolean hasCycle(boolean[] visited, List<List<Integer>> adj, int current, int parent) {
        visited[current] = true; // Mark the current node as visited
        // Iterate through all adjacent nodes of the current node
        for (int adjNode : adj.get(current)) {
            if (!visited[adjNode]) { // If the adjacent node is not visited yet
                visited[adjNode] = true; // Mark it as visited
                // Recursively call the method to perform DFS traversal on the adjacent node
                // If a cycle is detected in any adjacent subtree, return true
                if (hasCycle(visited, adj, adjNode, current)) {
                    return true;
                }
            } else if (parent != adjNode) { // If the adjacent node is visited and not the parent node
                return true; // This indicates the presence of a cycle
            }
        }
        return false; // If no cycle is detected after traversing all adjacent nodes, return false
    }
    
    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        int V = 5; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>(V);
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
        boolean hasCycle = detectCycle(V, adj);

        // Display the result
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

    // Helper method to add an edge to the adjacency list representation of the graph
    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
