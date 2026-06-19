class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, copy = 0;
        for(int i =0;i<gain.length;i++){
            copy += gain[i];
            max = Math.max(max, copy);
        }
        return max;
    }
}