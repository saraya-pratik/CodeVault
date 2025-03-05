class Solution {
    public long coloredCells(int n) {
        long ans = (long)(n - 1) * (long)(n) / 2l;
        return ans * 4 + 1;
    }
}