class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int [] freq = new int [26];

        for(char ch : brokenLetters.toCharArray()){
            freq[ch - 'a']++;
        }

        int res = 0;
        String [] str = text.split(" ");

        O : for(String word : str){
            for(char ch : word.toCharArray()){
                if(freq[ch - 'a'] > 0){
                    continue O;
                }
            }
            res++;
        }

        return res;
    }
}