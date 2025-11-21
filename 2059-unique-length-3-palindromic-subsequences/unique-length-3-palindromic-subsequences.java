class Solution {
    public int countPalindromicSubsequence(String s) {
        int res=0;
        int[] count=new int[123];
        for(int i=0;i<s.length()-2;i++){
            if(count[s.charAt(i)]!=0)
                continue;
            int[] countb=new int[123];
            for(int j=i+1;j<s.length()-1;j++){
                if(countb[s.charAt(j)]!=0)
                    continue;
                for(int k=j+1;k<s.length();k++)
                    if(s.charAt(i)==s.charAt(k)){
                        res++;
                        break;
                    }
                countb[s.charAt(j)]=1;
            }
            count[s.charAt(i)]=1;
        }
        return res;
    }
}