class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0; // will store total Palindromic subseq of length 3

        // Try each character from 'a' to 'z' as the outer character of the palindrome: x _ x
        for (char c = 'a'; c <= 'z'; c++) {
            // Find the first and last occurrence of character c in the string
            int L = s.indexOf(c);
            int R = s.lastIndexOf(c);

            // Valid palindrome x_y_x requires at least one character in between → R - L >= 2
            if (L != -1 && R - L >= 2) {
                // Collect all distinct middle characters between L and R
                HashSet<Character> mid = new HashSet<>();
                for (int i = L + 1; i < R; i++) {
                    // Every distinct middle character forms a unique palindrome: c + midChar + c
                    mid.add(s.charAt(i));
                }
                ans += mid.size(); // Number of distinct middle characters = number of unique palindromes for this outer character
            }
        }

        return ans;
    }
}