class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            max = Math.max(max , nums[i]);
        }
        int i = 0, j = 0, count = 0;
        long res = 0;
        while(j < n){
            if(nums[j] == max){
                count++;
            }
            while(count >= k){
                res += n - j;
                if(nums[i] == max){
                    count--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}