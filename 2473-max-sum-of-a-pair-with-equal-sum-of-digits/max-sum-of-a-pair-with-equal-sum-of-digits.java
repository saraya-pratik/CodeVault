class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for(int i : nums){
            int copy = i;
            int sum = 0;
            while(copy > 0){
                sum += copy % 10;
                copy /= 10;
            }
            if(map.containsKey(sum)){
                res = Math.max(res, map.get(sum) + i);
                map.put(sum, Math.max(map.get(sum), i));
            }
            else{
                map.put(sum, i);
            }
        }

        return res;
    }
}