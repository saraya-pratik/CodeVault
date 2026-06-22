class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] ch = new int [26];
        for(int i=0;i<text.length();i++){
            ch[text.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        String s = "balon";

        for(char ch1: s.toCharArray()){
            if(ch1 == 'l' || ch1 == 'o'){
                min = Math.min(min , ch[ch1 - 'a'] / 2);
            }
            else{
                min = Math.min(min, ch[ch1 - 'a']);
            }
        }
        return min;
    }
}