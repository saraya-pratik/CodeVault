class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMin = nums[0];
        int currMax = nums[0];
        int min = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++) {
            currMin = Math.min(nums[i], currMin+nums[i]);
            currMax = Math.max(nums[i], currMax+nums[i]);
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }

        return Math.abs(min)>Math.abs(max) ? Math.abs(min) : Math.abs(max); 
    }
}