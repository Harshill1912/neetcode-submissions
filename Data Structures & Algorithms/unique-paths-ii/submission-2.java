class Solution {

  
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];

         if(obstacleGrid[0][0] ==1 || obstacleGrid[n-1][m-1] == 1) return 0;

        dp[0][0]=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 ) continue;
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j]=-1;
                    continue;
                }
                int take=0;
                if(i -1 >= 0 && dp[i-1][j] != -1) take+=dp[i-1][j];
                if(j- 1 >=0 && dp[i][j-1] != -1) take+=dp[i][j-1];

                dp[i][j]=take;
            }
        }

        return dp[n-1][m-1];
    }
}