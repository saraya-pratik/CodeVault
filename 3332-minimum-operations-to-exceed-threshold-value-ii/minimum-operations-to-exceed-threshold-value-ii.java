class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;
        for(int i : nums){
            pq.add((long)i);
        }

        while(pq.size() >= 2 && pq.peek() < k){
            long first = pq.remove();
            long second = pq.remove();

            pq.add(first * 2 + second);
            count++;
        }

        return count;
    }
}