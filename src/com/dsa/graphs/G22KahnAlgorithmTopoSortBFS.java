/**
 * 	Given a DAG(direct acyclic graph), print Topological Sorting of a given graph
	
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints:
	1 <= T <= 10
	1 <= V <= 1000
	0 <= E <= 3000
	0 <= U, V <= V-1
	
	Time Limit: 1sec
	Sample Input 1:
	1
	5 4
	0 2
	1 2
	3 1
	0 4
	Sample Output 1:
	Correct
	Sample Output 1 Explanation:
	One correct sort order is : 3 1 0 4 2.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G22KahnAlgorithmTopoSortBFS {

    // This method performs topological sorting on a directed acyclic graph (DAG) using Kahn's algorithm.
    // It takes the number of vertices (V) and an adjacency list representation of the graph as input.
    // It returns an integer array representing the topological order of the graph, or null if the graph has a cycle.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        // Create an in-degree array to store the in-degree of each node in the graph.
        // The in-degree of a node is the number of edges directed towards it.
        int[] inDegree = new int[V];

        // Create a queue to store nodes with in-degree 0.
        Queue<Integer> q = new LinkedList<>();

        // Calculate the in-degree of each node by iterating through the adjacency list.
        // For each edge (i, j) in the graph, increment the in-degree of the destination node (j).
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        // Add all nodes with in-degree 0 to the queue.
        // These nodes have no incoming edges and can be processed immediately.
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Create an array to store the topological order of the graph.
        int[] topo = new int[V];

        // Initialize an index variable to keep track of the position in the topo array.
        int index = 0;

        // Process nodes while the queue is not empty.
        while (!q.isEmpty()) {
            // Remove the node from the queue.
            int node = q.poll();

            // Add the node to the topological order array.
            topo[index++] = node;

            // Decrement the in-degree of all neighbors of the processed node.
            // If a neighbor's in-degree becomes 0, add it to the queue.
            for (int adjNode : adj.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        // Check if all nodes have been processed. If not, the graph has a cycle.
        for (int i = 0; i < V; i++) {
            if (inDegree[i] > 0) {
                return null;
            }
        }

        // Return the topological order of the graph.
        return topo;
    }

    // **Main method (not provided in the original code)**
    // This method is for demonstration purposes only and is not strictly part of the Kahn's algorithm implementation.
    // You can remove or modify it as needed.
    public static void main(String[] args) {
        // Create a sample graph
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform topological sort using Kahn's algorithm
        int[] topoOrder = topoSort(V, adj);

        // Print the topological order
        if (topoOrder != null) {
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
        } else {
            System.out.println("Graph has a cycle.");
        }
    }
}
