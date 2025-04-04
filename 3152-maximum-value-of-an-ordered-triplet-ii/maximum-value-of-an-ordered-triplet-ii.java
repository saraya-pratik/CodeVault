class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxSuffix = new int[n];
        int max_k = 0;

        // Precompute max suffix values for nums[k]
        for (int i = n - 1; i >= 2; i--) {
            max_k = Math.max(max_k, nums[i]);
            maxSuffix[i - 1] = max_k;
        }

        int max_i = nums[0];
        long result = 0L;

        for (int j = 1; j < n - 1; j++) {
            long tripletValue = (long)(max_i - nums[j]) * maxSuffix[j];
            result = Math.max(result, tripletValue);
            max_i = Math.max(max_i, nums[j]);
        }

        return result;
    }
}