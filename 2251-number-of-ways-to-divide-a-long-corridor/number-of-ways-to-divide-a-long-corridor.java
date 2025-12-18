class Solution {
    public int numberOfWays(String corridor) {
        long ans=1,seatCount=0,recentPosition=0,mod=1000000000+7;

        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                if(++seatCount>2&&(seatCount&1)==1){
                    ans = ans*(i-recentPosition)%mod;
                }
                recentPosition = i;
            }
        }
        return (seatCount&1)==0 && seatCount>0 ? (int)ans:0;
    }
}