class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> langSets = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) set.add(lang);
            langSets.add(set);
        }
        
        Set<Integer> usersNeedTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            boolean canCommunicate = false;
            for (int lang : languages[u]) {
                if (langSets.get(v).contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                usersNeedTeach.add(u);
                usersNeedTeach.add(v);
            }
        }
        
        if (usersNeedTeach.isEmpty()) return 0;
        
        int[] freq = new int[n + 1];
        for (int user : usersNeedTeach) {
            for (int lang : languages[user]) {
                freq[lang]++;
            }
        }
        
        int maxFreq = 0;
        for (int i = 1; i <= n; i++) maxFreq = Math.max(maxFreq, freq[i]);
        
        return usersNeedTeach.size() - maxFreq;
    }
}