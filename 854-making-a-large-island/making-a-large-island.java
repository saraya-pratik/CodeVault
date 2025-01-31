import java.util.*;

class Solution {
    // Function to perform BFS and mark all connected components of an island
    public void bfs(int m, int n, Queue<int[]> q, int[][] grid, int[][] vis, int[] sum, int id, Map<Integer, Integer> maxisland) {
        int[] row = {-1, 0, 0, 1}; // Directions for moving up, right, left, down
        int[] col = {0, 1, -1, 0};

        while (!q.isEmpty()) {
            int[] val = q.poll();
            int r = val[0];
            int c = val[1];

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];

                // Check if the new position is within bounds and is part of the island
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    q.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1; // Mark as visited
                    grid[nrow][ncol] = id; // Assign island ID
                    sum[0]++; // Increase island size count
                }
            }
        }
        maxisland.put(id, sum[0]); // Store the size of this island
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n]; // Visited matrix
        Map<Integer, Integer> maxisland = new HashMap<>(); // Stores the size of each island
        int id = 2; // Start island ID from 2 (to distinguish from 0 and 1)
        int maxi = 0; // Stores the maximum island size found

        // Step 1: Identify all islands and store their sizes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    int[] sum = {1}; // Start with size 1 (current cell)
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = 1;
                    grid[i][j] = id; // Assign a unique ID to this island
                    bfs(m, n, q, grid, vis, sum, id, maxisland);
                    maxi = Math.max(maxi, sum[0]); // Update the maximum island size found
                    id++; // Increment island ID for next island
                }
            }
        }

        // Step 2: Try flipping each `0` to `1` and calculate the possible island size
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // Consider only water cells
                    Set<Integer> mp = new HashSet<>(); // Store unique adjacent island IDs
                    int num = 1; // Start with size 1 (flipping this cell to land)

                    int[] row = {-1, 0, 0, 1}; // Directions
                    int[] col = {0, 1, -1, 0};

                    // Check all 4 directions for adjacent islands
                    for (int k = 0; k < 4; k++) {
                        int nrow = i + row[k];
                        int ncol = j + col[k];

                        // If valid land cell and belongs to an island, add to set
                        if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] > 1) {
                            mp.add(grid[nrow][ncol]); // Store the unique island ID
                        }
                    }

                    // Sum up sizes of all unique adjacent islands
                    for (int val : mp) {
                        num += maxisland.get(val);
                    }

                    maxi = Math.max(maxi, num); // Update maximum island size found
                }
            }
        }

        return maxi; // Return the largest possible island size
    }
}