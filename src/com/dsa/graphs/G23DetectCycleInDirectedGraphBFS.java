/**
 * 	Given a directed graph, check whether the graph contains a cycle or not. 
 	Your function should return true if the given graph contains at least one 
 	cycle, else return false.
	
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints:
	1 <= T <= 10
	1 <= V <= 10^3
	0 <= E <= 10^3
	0 <= A, B < V
	
	Time Limit: 1 sec
	Sample Input 1:.
	2
	4 4
	0 1
	1 2
	2 3
	3 0
	3 3
	1 0
	1 2
	0 2
	Sample Output 1:
	true
	false
	Explanation for Sample Input 1:
	In the first case,
	From node 0 we can reach 0 again by following this sequence of nodes in the path: 0,1,2,3,0.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G23DetectCycleInDirectedGraphBFS {

    /**
     * Checks if a directed graph contains a cycle using Breadth-First Search (BFS).
     *
     * @param V: Number of vertices in the graph.
     * @param adj: Adjacency list representation of the graph.
     * @return true if the graph has a cycle, false otherwise.
     */
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        // Create an array to store the in-degree of each vertex.
        // In-degree represents the number of incoming edges to a vertex.
        int[] inDegree = new int[V];

        // Calculate the in-degree of each vertex by iterating through the adjacency list.
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        // Create a queue to store vertices with in-degree 0.
        Queue<Integer> q = new LinkedList<>();

        // Add all vertices with in-degree 0 to the queue.
        // These vertices have no incoming edges and cannot be part of a cycle.
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Initialize a counter to track the number of processed vertices.
        int count = 0;

        // Perform BFS traversal using the queue.
        while (!q.isEmpty()) {
            // Remove the vertex from the queue.
            int node = q.poll();

            // Increment the counter to track processed vertices.
            count++;

            // Iterate through the neighbors of the processed vertex.
            for (int adjNode : adj.get(node)) {
                // Decrement the in-degree of the neighbor.
                inDegree[adjNode]--;

                // If the neighbor's in-degree becomes 0, add it to the queue.
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        // If all vertices are not processed, there must be a cycle.
        // A cycle creates a back edge, preventing a node from reaching in-degree 0.
        return count < V;
    }

    // **Main method (not provided in the original code)**
    // This method is for demonstration purposes only and is not strictly part of the BFS implementation.
    // You can remove or modify it as needed.
    public static void main(String[] args) {
        // Create a sample graph
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);

        // Check for cycle
        G23DetectCycleInDirectedGraphBFS obj = new G23DetectCycleInDirectedGraphBFS();
        if (obj.isCyclic(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
