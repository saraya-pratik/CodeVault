class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] directions = new int[] {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(Comparator.comparingInt(i -> i[2]));
        heap.add(new int[] {0, 0, 0});
        visited[0][0] = true;
        while (true) {
            int[] e = heap.poll();
            if (e[0] == m - 1 && e[1] == n - 1) return e[2];
            for (int i = 0; i < 4; i++) {
                int x = e[0] + directions[i], y = e[1] + directions[i + 1];
                if (x > -1 && y > -1 && x < m && y < n && !visited[x][y]) {
                    heap.add(new int[] {x, y, e[2] + (Math.max(0, grid[x][y] - e[2]) | 1)});
                    visited[x][y] = true;
                }
            }
        }
    }

}