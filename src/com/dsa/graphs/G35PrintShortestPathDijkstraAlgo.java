/**
 * 	You are given a weighted undirected graph having n vertices numbered from 1 to n 
 	and m edges describing there are edges between a to b with some weight, 
 	find the shortest path between the vertex 1 and the vertex n and 
 	if path does not exist then return a list consisting of only -1.

	Note - 
	1. If there exists a path, then return a list whose first element is the weight of the path.
	2. If no path exists then return a list containing a single element -1.
	
	Example:
	Input:
	n = 5, m= 6
	edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
	Output:
	5 1 4 3 5
	Explaination:
	Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G35PrintShortestPathDijkstraAlgo {

    // A class to represent a pair (weight, node) used in the algorithm.
    private static class Pair {
        int node;   // Node connected by the edge
        int weight; // Weight of the edge

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" + node + "," + weight + "}";
        }
    }

    /**
     * Implements Dijkstra's algorithm to find the shortest path and its distance from a source node to a destination node.
     *
     * @param n: Number of vertices in the graph.
     * @param m: Number of edges in the graph.
     * @param edge: A 2D array representing edges of the graph, where edge[i][0] is the starting node, edge[i][1] is the ending node, and edge[i][2] is the weight of the edge.
     * @return A list containing the shortest path from the source node (assumed to be node 1) to the destination node (node n), or [-1] if no path exists.
     *
     * Time Complexity: O(E * log V), where:
     *   - E: Number of edges in the graph.
     *   - V: Number of vertices in the graph.
     *   - log V: Due to the logarithmic complexity of priority queue operations.
     *
     * Space Complexity: O(V + E), due to the adjacency list, priority queue, and parent array used in the algorithm.
     */
    public static List<Integer> shortestPath(int n, int m, int[][] edge) {

        // Create a priority queue to store pairs (weight, node) using a custom comparator for minimum weight.
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);

        // Create an adjacency list to represent the graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // Account for node indices starting from 1
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the edge array.
        for (int i = 0; i < m; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            int weight = edge[i][2];
            adj.get(node1).add(new Pair(node2, weight));
            adj.get(node2).add(new Pair(node1, weight)); // Add edges in both directions for undirected graphs.
        }

        // Initialize an array to store distances from the source node (node 1) to all other nodes, setting them to infinity initially.
        List<Integer> distance = new ArrayList<>();
        int[] parent = new int[n + 1]; // Parent array to track the path
        for (int i = 0; i <= n; i++) {
            distance.add((int) 1e9);
            parent[i] = i; // Initially, parent of each node is itself
        }

        // Start from source node (node 1) with distance 0.
        q.add(new Pair(1, 0));
        distance.set(1, 0);

        // Dijkstra's algorithm loop.
        while (!q.isEmpty()) {
            // Extract the node with the minimum weight from the priority queue.
            Pair current = q.poll();
            int currentWeight = current.weight;
            int currentNode = current.node;

            // Relax edges of the current node.
            for (Pair adjNodePair : adj.get(currentNode)) {
                int edgeWeight = adjNodePair.weight;
                int adjNode = adjNodePair.node;

                // Check if relaxing the edge improves the distance to the adjacent node.
                if (currentWeight + edgeWeight < distance.get(adjNode)) {
                    parent[adjNode] = currentNode; // Update parent for path tracking
                    distance.set(adjNode, currentWeight + edgeWeight);
                    q.add(new Pair(adjNode, distance.get(adjNode))); // Update the priority queue with the new distance.
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        // Check if no path exists to the destination node (node n)
        if (parent[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        // Reconstruct the shortest path using the parent array.
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1); // Add the source node (node 1) to the path
        Collections.reverse(path); // Reverse the path to get the order from source to destination

        return path;
    }

    public static void main(String[] args) {
        // Example usage of the shortestPath function

        int n = 5; // Number of vertices in the graph
        int m = 8; // Number of edges in the graph

        int[][] edge = {
            {1, 2, 1}, {1, 3, 2}, {2, 4, 4}, {3, 4, 5}, {3, 5, 1},
            {4, 5, 3}, {1, 5, 6}, {2, 5, 2}
        };

        List<Integer> shortestPath = shortestPath(n, m, edge);

        if (shortestPath.get(0) == -1) {
            System.out.println("No path exists from source to destination.");
        } else {
            System.out.println("Shortest path from source (node 1) to destination (node " + n + "):");
            for (int i = 0; i < shortestPath.size(); i++) {
                System.out.print(shortestPath.get(i) + " -> ");
            }
            System.out.println("END");
        }
    }
}

