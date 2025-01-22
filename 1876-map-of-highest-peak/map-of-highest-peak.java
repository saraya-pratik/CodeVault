class Solution {
    class Pair{
        int val;
        int i;
        int j;

        public Pair(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    pq.offer(new Pair(0,i,j));
                    visited[i][j] = true;
                }
            }
        }
        if(pq.isEmpty()){
            pq.offer(new Pair(1,0,0));
        }
        int[][] direction = {{0,1},{1,0},{0,-1}, {-1,0}};
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int i = temp.i;
            int j = temp.j;
            int val = temp.val;
            ans[i][j] = val;

            for(int[] dir : direction){
                int newR = i + dir[0];
                int newC = j + dir[1];

                if(newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC]){
                    continue;
                }
                else{
                    visited[newR][newC] = true;
                    pq.offer(new Pair(val+1, newR, newC));
                }
            }
        }

        return ans;
    }
}