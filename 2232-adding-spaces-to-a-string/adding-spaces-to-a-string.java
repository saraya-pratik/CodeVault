class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for(char ch : s.toCharArray()){
            if(ind < spaces.length && sb.length() - ind == spaces[ind]){
                sb.append(' ');
                ind++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}