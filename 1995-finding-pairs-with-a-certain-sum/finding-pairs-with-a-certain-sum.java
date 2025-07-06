class FindSumPairs {

    // Original input arrays
    public int[] numsFromFirstArray;
    public int[] numsFromSecondArray;

    // Frequency counters for elements in each array
    public HashMap<Integer, Integer> freqMapFirstArray = new HashMap<>();
    public HashMap<Integer, Integer> freqMapSecondArray = new HashMap<>();

    // Sorted unique keys from the first array (for faster search in count)
    public int[] sortedUniqueKeysFirstArray;

    public FindSumPairs(int[] nums1, int[] nums2) {
        // Store arrays
        this.numsFromFirstArray = nums1;
        this.numsFromSecondArray = nums2;

        // Build frequency map for first array
        for (int number : nums1) {
            freqMapFirstArray.put(number,
                freqMapFirstArray.getOrDefault(number, 0) + 1);
        }

        // Build frequency map for second array
        for (int number : nums2) {
            freqMapSecondArray.put(number,
                freqMapSecondArray.getOrDefault(number, 0) + 1);
        }

        // Extract unique sorted keys from the first array
        this.sortedUniqueKeysFirstArray = new int[freqMapFirstArray.size()];
        int index = 0;
        for (int key : freqMapFirstArray.keySet()) {
            sortedUniqueKeysFirstArray[index++] = key;
        }
        Arrays.sort(sortedUniqueKeysFirstArray);
    }

    public void add(int indexInSecondArray, int valueToAdd) {
        // Reduce frequency of old value at index
        int oldValue = numsFromSecondArray[indexInSecondArray];
        freqMapSecondArray.put(oldValue, 
            freqMapSecondArray.get(oldValue) - 1);

        // Update value in array
        numsFromSecondArray[indexInSecondArray] += valueToAdd;

        // Increase frequency of new value
        int newValue = numsFromSecondArray[indexInSecondArray];
        freqMapSecondArray.put(newValue, 
            freqMapSecondArray.getOrDefault(newValue, 0) + 1);
    }

    public int count(int targetSum) {
        int totalPairs = 0;

        // Try each unique number from first array
        for (int numInFirstArray : sortedUniqueKeysFirstArray) {
            // If number is already >= targetSum, skip remaining (since sorted)
            if (numInFirstArray >= targetSum) break;

            int requiredNumberInSecondArray = targetSum - numInFirstArray;

            // Count how many such pairs exist
            totalPairs += freqMapFirstArray.get(numInFirstArray)
                * freqMapSecondArray.getOrDefault(requiredNumberInSecondArray, 0);
        }

        return totalPairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */