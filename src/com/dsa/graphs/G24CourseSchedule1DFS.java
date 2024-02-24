/**
 * 	There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
	
	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
	Return true if you can finish all courses. Otherwise, return false.
	
	 
	
	Example 1:
	
	Input: numCourses = 2, prerequisites = [[1,0]]
	Output: true
	Explanation: There are a total of 2 courses to take. 
	To take course 1 you should have finished course 0. So it is possible.
	Example 2:
	
	Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 
 */
package com.dsa.graphs;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
public class G24CourseSchedule1DFS {

    /**
     * Time Complexity: O(V + E) in the worst case
     * Space Complexity: O(V)
     *
     * Determines if it's possible to finish all courses given their prerequisites using Depth-First Search (DFS).
     *
     * @param numCourses: Total number of courses.
     * @param prerequisites: Array of prerequisite pairs, where [a, b] indicates that course b is a prerequisite for course a.
     * @return true if all courses can be finished, false if there's a cycle in the prerequisites.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create an adjacency list to represent the course dependencies.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]); // Add edges from prerequisites to courses
        }

        // Create arrays to track visited nodes and nodes in the current DFS path.
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        // Perform DFS traversal from each unvisited node.
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(adj, visited, pathVisited, i)) {
                    return false; // Cycle detected, courses cannot be finished.
                }
            }
        }

        // No cycles found, all courses can be finished.
        return true;
    }

    /**
     * Time Complexity: O(V + E) in the worst case
     * Space Complexity: O(V) due to recursion stack
     *
     * Helper function to check for cycles in the DFS traversal.
     *
     * @param adj: Adjacency list representing course dependencies.
     * @param visited: Array to track visited nodes.
     * @param pathVisited: Array to track nodes in the current DFS path.
     * @param node: Current node being explored in DFS.
     * @return true if a cycle is found, false otherwise.
     */
    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true; // Mark current node as visited.
        pathVisited[node] = true; // Mark current node as part of the current DFS path.

        // Explore neighbors of the current node.
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) { // Unvisited neighbor, continue DFS exploration.
                if (hasCycle(adj, visited, pathVisited, neighbor)) {
                    return true; // Cycle found in a deeper part of the DFS tree.
                }
            } else if (pathVisited[neighbor]) { // Visited neighbor already in the current DFS path, cycle detected.
                return true;
            }
        }

        // Backtrack: remove current node from the DFS path.
        pathVisited[node] = false;

        return false; // No cycle found in the current DFS exploration.
    }

    // **Main method (for demonstration purposes)**
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        G24CourseSchedule1DFS obj = new G24CourseSchedule1DFS();
        if (obj.canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Courses cannot be finished due to a cycle.");
        }
    }
}
