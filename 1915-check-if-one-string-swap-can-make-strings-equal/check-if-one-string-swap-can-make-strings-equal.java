class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        int count = 0;
        int i1 = -1, i2 = -1;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count % 2 != 0){
                    i1 = i;
                }
                else{
                    i2 = i;
                }
            }
        }

        if(count > 2 || count == 1){
            return false;
        }
        else if(count == 0){
            return true;
        }
        else{
            if(s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}