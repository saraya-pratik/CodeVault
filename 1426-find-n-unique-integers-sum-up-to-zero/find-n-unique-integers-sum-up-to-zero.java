class Solution {
    public int[] sumZero(int n) {
        int [] res = new int [n];
        int i1 = 0, i2 = n-1;
        int copy = n;
        while(i1 < i2){
            res[i1++] = -copy;
            res[i2--] = copy;
            copy++;
        }
        return res;
    }
}