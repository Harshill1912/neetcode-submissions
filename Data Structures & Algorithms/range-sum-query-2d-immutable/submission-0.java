class NumMatrix {
     int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        prefixSum=new int[n][m];

        for(int i=0;i<n;i++){
         prefixSum[i][0]=matrix[i][0];
          for(int j=1;j<m;j++){
            prefixSum[i][j]=matrix[i][j]+prefixSum[i][j-1];
          }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
         int sum=0;

         for(int row=row1;row<=row2;row++){
            if(col1 > 0){
                sum+=prefixSum[row][col2] - prefixSum[row][col1 -1 ];
            }else{
                sum+=prefixSum[row][col2];
            }
         }   
         return sum;
    } 
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */