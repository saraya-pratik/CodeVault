class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, pre = 0, mod = (int)(1e9 + 7);
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            pre += arr[i];
            if(pre % 2 == 0){
                ans += odd;
            }
            else{
                ans += i + 1 - odd;
                odd++;
            }
            ans %= mod;
        }

        return ans;
    }
}