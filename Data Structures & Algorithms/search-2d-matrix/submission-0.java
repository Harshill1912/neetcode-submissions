class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        Arrays.sort(matrix,(a,b) -> a[0]-b[0]);
        int n=matrix.length;
        int m=matrix[0].length;
        int si=0;
        int ei=(n*m)-1;

         while(si<=ei){
             int mi=si+(ei-si)/2;
             int row=mi /m;
             int col=mi % m;

              if(matrix[row][col] == target){
                return true;
              }else if(matrix[row][col] > target){
                ei=mi-1;
              }else{
                si=mi+1;
              }
         }
         return false;
    }
}
