import java.util.*;

class Solution {
    // Depth-First Search (DFS) function to detect cycles in the graph
    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true; // Mark the current node as visited

        for (int neighbor : adj.get(node)) { // Traverse all adjacent nodes
            if (!visited[neighbor]) { // If the neighbor is not visited
                if (dfs(neighbor, node, visited, adj)) return true; // Recursive DFS call
            } else if (neighbor != parent) { 
                // If we visit a node that is not the parent, it means a cycle is detected
                System.out.println(neighbor + " " + parent); // Print the cycle for debugging
                return true;
            }
        }
        return false; // No cycle found
    }

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list for the graph
        for (int i = 0; i <= m; i++) adj.add(new ArrayList<>());
        boolean[] visited = new boolean[m + 1]; // Visited array to track nodes

        for (int[] edge : edges) { // Iterate over all edges
            int u = edge[0], v = edge[1];

            Arrays.fill(visited, false); // Reset visited array before checking for cycles
            adj.get(u).add(v); // Add edge (u, v)
            adj.get(v).add(u); // Add edge (v, u) since it’s an undirected graph

            if (dfs(u, -1, visited, adj)) { // Check if adding this edge forms a cycle
                return new int[]{u, v}; // Return the redundant edge that creates the cycle
            }
        }
        return new int[0]; // Return an empty array if no redundant edge is found
    }
}