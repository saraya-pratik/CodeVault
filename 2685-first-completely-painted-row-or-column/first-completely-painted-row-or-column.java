class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                map.put(mat[i][j], new Pair(i,j));
            }
        }
        int [] rows = new int[mat.length];
        Arrays.fill(rows, mat[0].length);
        
        int [] cols = new int [mat[0].length];
        Arrays.fill(cols, mat.length);

        for(int i=0; i<arr.length; i++){
            Pair p = map.get(arr[i]);
            if(rows[p.x] - 1 == 0){
                return i;
            }
            else{
                rows[p.x]--;
            }

            if(cols[p.y] - 1 == 0){
                return i;
            }
            else{
                cols[p.y]--;
            }
        }
        return -1;//Should never be reached
    }
    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}