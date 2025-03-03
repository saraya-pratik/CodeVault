class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int smlCnt = 0, pvtCnt = 0, lgrCnt = 0;
        for(int i : nums){
            if(i < pivot){
                smlCnt++;
            }
            else if(i == pivot){
                pvtCnt++;
            }
            else{
                lgrCnt++;
            }
        }
        int [] res = new int [nums.length];
        int smlInd = 0, pvtInd = smlCnt, lgrInd = nums.length - lgrCnt;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                res[smlInd++] = nums[i];
            }
            else if(nums[i] == pivot){
                res[pvtInd++] = nums[i];
            }
            else{
                res[lgrInd++] = nums[i];
            }
        }

        return res;
    }
}