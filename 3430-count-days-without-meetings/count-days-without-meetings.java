class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        int n = meetings.length;
        int ans = meetings[0][0] - 1;
        for(int i=0;i<n - 1;i++){
            int j = i+1;
            while(j < n && meetings[i][1] >= meetings[j][0] && meetings[i][1] >= meetings[j][1]){
                j++;
            }
            if(j >= n){
                ans += days - meetings[i][1];
                return ans;
            }
            if(meetings[i][1] < meetings[j][0]){
                ans += (meetings[j][0] - meetings[i][1] - 1);
                i = j-1;
            }
            else if(meetings[i][1] < meetings[j][1]){
                i = j-1;
            }
        }
        ans += days - meetings[n - 1][1];
        
        return ans;
    }
}