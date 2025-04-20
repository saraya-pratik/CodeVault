class Solution {
    public int numRabbits(int[] answers) {
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (!map.containsKey(answer) || map.get(answer) == 0) {
                total += answer + 1;
                map.put(answer, answer);
            } else {
                map.put(answer, map.get(answer) - 1);
            }
        }

        return total;
    }
}