/**
 * 
 *   USING SET
	You have been given an undirected, connected graph of ‘V’ vertices (labelled from 0 to V-1) and ‘E’ edges. Each edge connecting two nodes 'u' and 'v' has a weight denoting the distance between them.
	Your task is to find the shortest path distance from the source node 'S' to all the vertices. You have to return a list of integers denoting the shortest distance between each vertex and source vertex 'S'.
	Note:
	1. There are no self-loops(an edge connecting the vertex to itself) in the given graph.
	2. There are no parallel edges i.e no two vertices are directly connected by more than 1 edge.
	For Example:
	Input:
	4 5
	0 1 5
	0 2 8
	1 2 9
	1 3 2
	2 3 6
	The source node is node 0.
	The shortest distance from node 0 to node 0 is 0.
	The shortest distance from node 0 to node 1 is 5. In the above figure, the green path represents this distance. The path goes from node 0->1, giving distance = 5.
	The shortest distance from node 0 to node 2 is 8. In the above figure, the pink path represents this distance. The path goes from node 0->2, giving distance = 8.
	The shortest distance from node 0 to node 3 is 7. In the above figure, the yellow path represents this distance. The path goes from node 0->1->3, giving distance = 7.

	Sample Input 1
	5 7 0
	0 1 7
	0 2 1
	0 3 2
	1 2 3
	1 3 5 
	1 4 1
	3 4 7
	Sample Output 1
	0 4 1 2 5
	Explanation of sample input 1
	The source node is node 0.
	The shortest distance from node 0 to node 0 is 0.
	The shortest distance from node 0 to node 1 is 4. In the above figure, the green path represents this distance. The path goes from node 0->2->1, giving distance = 1+3 = 4.
	The shortest distance from node 0 to node 2 is 1. In the above figure, the red path represents this distance. The path goes from node 0->2, giving distance = 1
	The shortest distance from node 0 to node 3 is 2. In the above figure, the pink path represents this distance. The path goes from node 0->3, giving distance = 2.
	The shortest distance from node 0 to node 4 is 5. In the above figure, the yellow path represents this distance. The path goes from node 0->2->1->4, giving distance = 1+3+1 = 5.
	Sample Input 2:
	3 3 2
	1 0 9
	2 1 8
	0 2 4
	Sample Output 2:
	4 8 0 
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author KowlutlaSwamy
 *
 */
public class G32DijkstrasShortestPathUsingSet {

    // A class to represent a pair (weight, node) used in the algorithm.
    private static class Pair {
        int weight; // Weight of the edge
        int node;   // Node connected by the edge

        public Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }

        @Override
        public String toString() {
            return "{" + node + "," + weight + "}";
        }

        // Override hashCode and equals for efficient set operations based on both weight and node
        @Override
        public int hashCode() {
            return Objects.hash(node, weight);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return node == other.node && weight == other.weight;
        }
    }

    /**
     * Implements Dijkstra's algorithm using a set to find the shortest paths from a source node to all other nodes.
     *
     * @param edge: A 2D array representing edges of the graph, where edge[i][0] is the starting node, edge[i][1] is the ending node, and edge[i][2] is the weight of the edge.
     * @param vertices: The number of vertices in the graph.
     * @param edges: The number of edges in the graph.
     * @param source: The source node from which to start finding shortest paths.
     * @return A list containing the shortest distances from the source node to all other nodes.
     *
     * Time Complexity: O(E * log V), where:
     *   - E: Number of edges in the graph.
     *   - V: Number of vertices in the graph.
     *   - log V: Due to the logarithmic complexity of set operations for removing and adding elements.
     *
     * Space Complexity: O(V + E), due to the adjacency list and set used in the algorithm.
     */
    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {

        // Use a set instead of a priority queue for efficient removal and update based on both weight and node.
        Set<Pair> q = new HashSet<>();

        // Create an adjacency list to represent the graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the edge array.
        for (int i = 0; i < edges; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            int weight = edge[i][2];
            adj.get(node1).add(new Pair(weight, node2));
            adj.get(node2).add(new Pair(weight, node1)); // Add edges in both directions for undirected graphs.
        }

        // Initialize an array to store distances from the source node to all other nodes, setting them to infinity initially.
        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            distance.add((int) 1e9);
        }

        // Add the source node with distance 0 to the set.
        q.add(new Pair(0, source));
        distance.set(source, 0); // Update the distance of the source node to 0.

        // Dijkstra's algorithm loop.
        while (!q.isEmpty()) {
            // Extract the node with the minimum weight from the set.
            Pair current = q.iterator().next(); // Efficiently access the first element of the set.
            int currentWeight = current.weight;
            int currentNode = current.node;
            q.remove(current); // Remove the current node from the set.

            // Relax edges of the current node.
            for (Pair adjNodePair : adj.get(currentNode)) {
                int edgeWeight = adjNodePair.weight;
                int adjNode = adjNodePair.node;

                // Check if relaxing the edge improves the distance to the adjacent node.
                if (currentWeight + edgeWeight < distance.get(adjNode)) {
                    // If the node exists in the set with a higher distance, remove it.
                    if (distance.get(adjNode) != (int) 1e9) {
                        q.remove(new Pair(distance.get(adjNode), adjNode));
                    }
                    // Update the distance and add the node back to the set with the new weight.
                    distance.set(adjNode, currentWeight + edgeWeight);
                    q.add(new Pair(distance.get(adjNode), adjNode));
                }
            }
        }

        // Return the list of shortest distances from the source node to all other nodes.
        return distance;
    }

    public static void main(String[] args) {
        // Example usage of the dijkstra function

        int[][] graph = {
            {0, 1, 4}, {0, 2, 1}, {1, 2, 3}, {2, 3, 2}, {3, 0, 7}
        }; // Sample graph with weights on edges

        int vertices = 4; // Number of vertices in the graph
        int edges = graph.length; // Number of edges in the graph
        int source = 0; // Source node

        List<Integer> shortestDistances = dijkstra(graph, vertices, edges, source);

        // Print the shortest distances from the source node to all other nodes
        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + shortestDistances.get(i));
        }
    }
}

