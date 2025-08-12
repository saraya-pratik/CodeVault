class Solution {
    public int solve(int n, int x, int i, int sum, int[][] dp, ArrayList<Integer>pow) {
        int mod = (int)1e9 + 7;
        if (sum == n) return 1;
        if (sum > n) return 0;
        if (i >= pow.size()) return 0; 
        
        if (dp[i][sum] != -1) return dp[i][sum];

        int take = 0;
        
        if (sum + pow.get(i) <= n) {
            take = solve(n, x, i + 1, sum + pow.get(i), dp, pow);
        }
       
        int skip = solve(n, x, i + 1, sum, dp, pow);

        return dp[i][sum] = (int)(((long)take + skip) % mod);
    }

    public int numberOfWays(int n, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int base = 1;base<=n; base++) {
            int pow=(int)Math.pow(base,x);
            if(pow>n)
            break;
            list.add( pow);
        }
       

        int[][] dp = new int[list.size() + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n, x, 0, 0, dp, list);
    }
}