class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int currSum=0;
        int n=triangle.size();
        currSum=triangle.get(0).get(0);
        int[][] x=new int[n][n];
        for(int[] y:x){
            Arrays.fill(y,Integer.MAX_VALUE);
        }
        currSum+=Math.min(func(triangle,1,0,n,x),func(triangle,1,0,n,x));
        return currSum;
    }

    int func(List<List<Integer>> triangle,int row,int index,int n,int[][] x){
        if(row==n) return 0;
        if(x[row][index]!=Integer.MAX_VALUE) return x[row][index];
        x[row][index]= Math.min(triangle.get(row).get(index)+func(triangle,row+1,index,n,x),triangle.get(row).get(index+1)+func(triangle,row+1,index+1,n,x));
        return x[row][index];
    }
}