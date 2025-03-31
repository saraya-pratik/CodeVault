class Solution {
    public long putMarbles(int[] weights, int k) {
        int [] arr = new int [weights.length-1];
        for(int i=0;i<weights.length-1;i++){
            arr[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(arr);
        long max = 0 , min =0;
        for(int i =0 ;i<k-1;i++){
            max += arr[arr.length-i-1];
            min += arr[i];
        }
        return max - min;
    }
}