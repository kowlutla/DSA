/**
 * 	You are given an Undirected Graph having unit weight, 
 	Find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
	
	Example:
	Input:
	n = 9, m= 10
	edges=[[0,1],[0,3],[3,4],[4 ,5]
	,[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
	src=0
	Output:
	0 1 2 1 2 3 3 4 4
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G27ShortestPathInUnDirectedGraphUnitLength {
	
	private static class Pair
	{
		int node;
		int distance;
		
		public Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

    /**
     * Finds the shortest paths from a source node to all other nodes in an unweighted undirected graph.
     *
     * @param edges: A 2D array representing edges, where edges[i] = [node1, node2] denotes an edge between node1 and node2.
     * @param n: Number of nodes in the graph.
     * @param m: Number of edges in the graph.
     * @param src: Source node from which to start finding shortest paths.
     * @return An array where distance[i] represents the shortest path length from the source node to node i, or -1 if there is no path.
     *
     * Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges.
     * Space Complexity: O(V) due to the queue and distance array.
     */
    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an adjacency list representation of the graph.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1); // Add edges for both directions in an undirected graph.
        }

        // Initialize distances to -1 (unknown) and create a queue for BFS traversal.
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Pair> q = new LinkedList<>();

        // Mark the source node as visited and start BFS with distance 0.
        q.add(new Pair(src, 0));
        distance[src] = 0;

        // Perform BFS traversal to explore nodes and update distances.
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            // Iterate through neighbors of the current node.
            for (int adjNode : adj.get(currentNode)) {
                // If the neighbor hasn't been visited yet, update its distance and add it to the queue.
                if (distance[adjNode] == -1) {
                    distance[adjNode] = currentDistance + 1;
                    q.add(new Pair(adjNode, currentDistance + 1));
                }
            }
        }

        return distance;
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        int n = 4; // Number of nodes
        int m = 6; // Number of edges
        int src = 0; // Source node

        int[] distances = shortestPath(edges, n, m, src);

        System.out.println("Shortest distances from source node " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + (distances[i] != -1 ? distances[i] : "unreachable"));
        }
    }
}
