class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1, curr = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < curr){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j] > nums[i])
                        res = Math.max(res, nums[j] - nums[i]);
                }
                curr = nums[i];
            } 
        }

        return res;
    }
}