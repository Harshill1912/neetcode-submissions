class Solution {
    static int[][]dp;
    public static int helper(int[][] grid,int row,int col){
        int n=grid.length;
        int m=grid[0].length;
        if(row == n-1 && col == m-1) return 1;

        if(dp[row][col] != -1) return dp[row][col];

        int take=0;
        if(row + 1 < n && grid[row+1][col] != 1){
            take+=helper(grid,row+1,col);
        }

        if(col +1 < m && grid[row][col+1] != 1){
            take+=helper(grid,row,col+1);
        }

        return dp[row][col] = take;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        dp=new int[n][m];

          if(obstacleGrid[0][0] ==1 || obstacleGrid[n-1][m-1] == 1) return 0;

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(obstacleGrid,0,0);
    }
}