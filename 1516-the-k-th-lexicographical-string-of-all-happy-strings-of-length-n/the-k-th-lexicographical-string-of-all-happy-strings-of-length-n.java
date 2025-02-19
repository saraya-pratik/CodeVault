import java.util.*;

class Solution {
    private void generateString(int n, String current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (!current.isEmpty() && current.charAt(current.length() - 1) == ch) continue;
            generateString(n, current + ch, happyStrings);
        }
    }

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateString(n, "", happyStrings);
        if (happyStrings.size() < k) return "";
        return happyStrings.get(k - 1);
    }
}