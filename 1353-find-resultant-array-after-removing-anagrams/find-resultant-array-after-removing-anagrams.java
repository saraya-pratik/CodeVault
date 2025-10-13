import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], result.get(result.size() - 1))) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;

        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }
}