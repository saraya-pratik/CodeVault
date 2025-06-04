class Solution 
{
    public int dfs(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes, Set<Integer> visited, Set<Integer> foundBoxes) 
    {
        // Step 2.1: Skip if already visited
        if (visited.contains(box))
        {
            return 0;
        } 

        // Step 2.2: If box is closed, remember it and skip
        if (status[box] == 0) 
        {
            foundBoxes.add(box);
            return 0;
        }

        // Step 2.3: Mark as visited and collect candies
        visited.add(box);
        int candiesCollected = candies[box];

        // Step 3.1: Try to open contained boxes
        for (int innerBox : containedBoxes[box]) 
        {
            candiesCollected += dfs(innerBox, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        // Step 3.2: Use keys to unlock other boxes
        for (int boxKey : keys[box]) 
        {
            status[boxKey] = 1;
            // Step 3.3: If we found this box earlier, try to open it now
            if (foundBoxes.contains(boxKey)) 
            {
                candiesCollected += dfs(boxKey, status, candies, keys, containedBoxes, visited, foundBoxes);
            }
        }

        return candiesCollected;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) 
    {
        // Step 1: Initialization
        int candiesCollected = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> foundBoxes = new HashSet<>();

        // Step 2: Process each initial box
        for (int box : initialBoxes) 
        {
            candiesCollected += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        return candiesCollected;
    }
}