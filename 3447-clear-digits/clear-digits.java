class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        String str = "";
        while(!st.isEmpty()){
            str = st.pop() + str;
        }

        return str;
    }
}