/**
 * 	There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 	You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you 
 	must take course bi first if you want to take course ai.
	
	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
	Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
	return any of them. If it is impossible to finish all courses, return an empty array.
	
	Example 1:
	Input: numCourses = 2, prerequisites = [[1,0]]
	Output: [0,1]
	Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
	So the correct course order is [0,1].

	Example 2:
	Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
	Output: [0,2,1,3]
	Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
	Both courses 1 and 2 should be taken after you finished course 0.
	So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

	Example 3:
	Input: numCourses = 1, prerequisites = []
	Output: [0]
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class G25CourseSchedule2DFS {

    /**
     * Time Complexity: O(V + E) in the worst case
     * Space Complexity: O(V)
     *
     * Finds a topological ordering of courses using Depth-First Search (DFS) if possible,
     * indicating the order in which courses can be taken without violating prerequisites.
     *
     * @param n: Total number of courses.
     * @param m: Number of prerequisite pairs.
     * @param prerequisites: Array of prerequisite pairs, where [a, b] indicates that course b is a prerequisite for course a.
     * @return An array representing the topological ordering of courses, or an empty array if no order exists due to cycles.
     */
    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {

        // Create an adjacency list to represent the course dependencies.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> prereq : prerequisites) {
            int present = prereq.get(0);
            int pre = prereq.get(1);
            adj.get(pre).add(present); // Add edges from prerequisites to courses
        }

        // Create arrays to track visited nodes and nodes in the current DFS path.
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        // Create a stack to store the topological order during DFS.
        Stack<Integer> stack = new Stack<>();

        // Perform DFS traversal from each unvisited node.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycle(adj, visited, pathVisited, stack, i)) {
                    return new int[]{}; // Cycle detected, no valid topological order exists.
                }
            }
        }

        // Extract the topological order from the stack.
        int[] result = new int[n];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }

    /**
     * Time Complexity: O(V + E) in the worst case
     * Space Complexity: O(V) due to recursion stack
     *
     * Helper function to check for cycles and build the topological order during DFS.
     *
     * @param adj: Adjacency list representing course dependencies.
     * @param visited: Array to track visited nodes.
     * @param pathVisited: Array to track nodes in the current DFS path.
     * @param stack: Stack to store the topological order.
     * @param node: Current node being explored in DFS.
     * @return true if a cycle is found, false otherwise.
     */
    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        // Explore neighbors of the current node.
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                if (hasCycle(adj, visited, pathVisited, stack, adjNode)) {
                    return true;
                }
            } else if (pathVisited[adjNode]) {
                return true; // Cycle detected.
            }
        }

        pathVisited[node] = false;
        stack.push(node); // Add node to the topological order after exploring its children.
        return false;
    }

    public static void main(String[] args) {
        int n = 4; // Number of courses
        int m = 4; // Number of prerequisite pairs

        // Sample prerequisite pairs (modify as needed)
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(new ArrayList<>(Arrays.asList(1, 0)));
        prerequisites.add(new ArrayList<>(Arrays.asList(2, 0)));
        prerequisites.add(new ArrayList<>(Arrays.asList(3, 1)));
        prerequisites.add(new ArrayList<>(Arrays.asList(3, 2)));

        int[] order = findOrder(n, m, prerequisites);

        if (order.length > 0) {
            System.out.println("Topological order: ");
            for (int course : order) {
                System.out.print(course + " ");
            }
        } else {
            System.out.println("No valid topological order exists due to cycles.");
        }
    }
}