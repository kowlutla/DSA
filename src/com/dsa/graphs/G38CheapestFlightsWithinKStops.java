/**
 * 	There are n cities connected by some number of flights. 
 	You are given an array flights where flights[i] = [fromi, toi, pricei] indicates 
 	that there is a flight from city fromi to city toi with cost pricei.
	
	You are also given three integers src, dst, and k, return the cheapest price from src to dst 
	with at most k stops. If there is no such route, return -1.
	
	 
	
	Example 1:
	
	
	Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
	Output: 700
	Explanation:
	The graph is shown above.
	The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
	Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
	Example 2:
	
	
	Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
	Output: 200
	Explanation:
	The graph is shown above.
	The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
	Example 3:
	
	
	Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
	Output: 500
	Explanation:
	The graph is shown above.
	The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
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
public class G38CheapestFlightsWithinKStops {

    // A class to represent a flight destination and its cost.
    private class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // A class to represent a node in the search process, including the node itself,
    // the number of stops taken to reach it, and the accumulated cost.
    private class Pair {
        int stops;
        int cost;
        int node;

        public Pair(int node, int stops, int cost) {
            this.node = node;
            this.stops = stops;
            this.cost = cost;
        }
    }

    /**
     * Finds the cheapest price to reach a destination within a maximum number of stops.
     *
     * @param n: Number of cities (nodes).
     * @param flights: A 2D array representing flight connections (from, to, cost).
     * @param src: The starting city (source).
     * @param dst: The destination city.
     * @param k: The maximum allowed number of stops.
     * @return The cheapest price to reach the destination within k stops, or -1 if no path exists.
     *
     * Time Complexity: O(V + E), where:
     *   - V: Number of cities (nodes).
     *   - E: Number of flight connections (edges).
     *
     * Space Complexity: O(V + E), due to the adjacency list and queue used in the algorithm.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build an adjacency list to represent flight connections.
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            adj.get(from).add(new Node(to, cost));
        }

        // Use a queue to perform Breadth-First Search (BFS) exploration.
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0)); // Start from source with 0 stops and 0 cost.

        // Initialize an array to store the cheapest cost found to reach each city so far.
        // Fill it with infinity values except for the source (set to 0).
        int[] cost = new int[n];
        Arrays.fill(cost, (int) 1e9);
        cost[src] = 0;

        // BFS loop to explore neighboring cities.
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currentStops = current.stops; // Number of stops taken so far.
            int currentCost = current.cost; // Accumulated cost.
            int currentNode = current.node; // Current city being explored.

            // Skip cities if the number of stops used to reach them exceeds the limit.
            if (currentStops > k) {
                continue;
            }

            // Explore neighboring cities (flights) from the current city.
            for (Node adjNode : adj.get(currentNode)) {
                int toNode = adjNode.to; // Destination city of the flight.
                int adjCost = adjNode.cost; // Cost of the flight.

                // Update the cost to reach the neighboring city if a cheaper path is found
                // and the number of stops is within the limit.
                if (currentCost + adjCost < cost[toNode] && currentStops <= k) {
                    cost[toNode] = currentCost + adjCost;
                    q.add(new Pair(toNode, currentStops + 1, currentCost + adjCost));
                }
            }
        }

        // If the cost to reach the destination city is still infinity, no path exists.
        if (cost[dst] == (int) 1e9) {
            return -1;
        }

        // Return the cheapest cost found to reach the destination city.
        return cost[dst];
    }

    // **Example Usage (Optional):**
    public static void main(String[] args) {
        int n = 3;  // Number of cities
        int[][] flights = {{0, 1, 100}, {0, 2, 500}, {1, 2, 200}};
        int src = 0;  // Starting city
        int dst = 2;  // Destination city
        int k = 1;    // Maximum allowed stops

        G38CheapestFlightsWithinKStops solution = new G38CheapestFlightsWithinKStops();
        int minPrice = solution.findCheapestPrice(n, flights, src, dst, k);

        if (minPrice == -1) {
            System.out.println("No path found to reach the destination within " + k + " stops.");
        } else {
            System.out.println("Minimum price to reach destination: " + minPrice);
        }
    }
}