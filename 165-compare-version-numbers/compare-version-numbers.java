class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int max_len = Math.max(v1.length , v2.length);
        int v1_i [] = new int [max_len];
        int v2_i [] = new int [max_len];

        for(int i = 0; i < v1.length; i++){
            v1_i [i] = Integer.parseInt(v1[i]);
        }
        for(int i = 0; i < v2.length; i++){
            v2_i [i] = Integer.parseInt(v2[i]);
        }

        for(int i = 0 ; i < max_len; i++){
            int diff = v1_i[i] - v2_i[i];
            if(diff > 0){
                return 1;
            }
            else if(diff < 0){
                return -1;
            }
        }
        return 0;
    }
}