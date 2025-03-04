class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n > 0){
            int pow = (int)(Math.log(n) / Math.log(3));
            if((int)Math.pow(3,pow + 1) <= n){
                pow++;
            }
            n -= (int)(Math.pow(3, pow));
            if(set.contains(pow)){
                return false;
            }
            set.add(pow);
        }
        return true;
    }
}