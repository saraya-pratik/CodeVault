class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> colors = new HashMap<>();
        int[] res = new int[n];
        for (int i = 0, distinct = 0; i < n; i++){
            int x = queries[i][0], y = queries[i][1];
            freq.put(y, freq.getOrDefault(y, 0) + 1);
            if (freq.get(y) == 1)
                distinct++;
            if (colors.containsKey(x)){
                int prev = colors.get(x);
                freq.put(prev, freq.get(prev) - 1);
                if (freq.get(prev) == 0)
                    distinct--;
            }
            colors.put(x, y);
            res[i] = distinct;
        }
        return res;
    }
}