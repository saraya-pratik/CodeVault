class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], ans = nums[0];

        for(int i=1;i<nums.length;i++){
            sum = nums[i] > nums[i - 1] ? sum + nums[i] : nums[i];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}