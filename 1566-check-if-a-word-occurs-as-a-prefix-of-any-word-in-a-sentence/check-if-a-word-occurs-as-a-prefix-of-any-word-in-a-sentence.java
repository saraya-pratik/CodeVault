class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] arr = sentence.split(" ");
        int wcount  = 0;
        for(String s : arr){
            wcount++;
            int count = 0;
            if(s.length() < searchWord.length()){
                continue;
            }else{

                int j = 0;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == searchWord.charAt(j)){
                        count++;
                        j++;
                    }
                    else{
                        break;
                    }
                    if (count == searchWord.length()){
                        break;
                    }
                }
            }
            if(count == searchWord.length()){
                return wcount;
            }
        }
        return -1;
    }
}