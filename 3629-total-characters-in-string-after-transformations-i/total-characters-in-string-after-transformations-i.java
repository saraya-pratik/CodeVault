class Solution {
    public int lengthAfterTransformations(String s, int t) {
    int MOD=1000000007;
     int ans=0;

     long[] cnt=new long[26];
     for(char ch:s.toCharArray())
     {
        cnt[ch-'a']++;
     }

     for(;t>=26;t-=26)
     {
        long z=cnt[25];
        for(int i=25;i>0;i--)
        {
            cnt[i]=(cnt[i]+cnt[i-1])%MOD;
        }
        cnt[0]=(cnt[0]+z)%MOD;
        cnt[1]=(cnt[1]+z)%MOD;
     }

     for(int i=0;i<26;i++)
     {
        ans=(int)((ans+cnt[i])%MOD);
     }

     for(int i=26-t;i<26;i++)
     {
        ans=(int)((ans+cnt[i])%MOD);
     }
     return ans;
    }
}