class Solution {
    public boolean canChange(String start, String target) {
        int i1 = 0;
        int i2 = 0;
        while (true) {
            while(i1 < target.length() && target.charAt(i1) == '_') {
                i1++;
            }
            while(i2 < start.length() && start.charAt(i2) == '_') {
                i2++;
            }
            if (i1 == target.length() || i2 == start.length()) {
                break;
            }
            if (target.charAt(i1) != start.charAt(i2)) {
                return false;
            }
            if (target.charAt(i1) == 'L' && i1 > i2) {
                return false;
            }
            if (target.charAt(i1) == 'R' && i1 < i2) {
                return false;
            }
            i1++;
            i2++;
        }
        return i1 == i2;
    }
}