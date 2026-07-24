class Solution {
    static int[][] dp;
    public static int helper(int[][] grid,int row,int col){
        int n=grid.length;
        int m=grid[0].length;

        if(row == n-1 && col == m-1) return grid[n-1][m-1];

        if(dp[row][col] != -1) return dp[row][col];

        int take1=Integer.MAX_VALUE;
        if(row + 1 < n){
            take1=grid[row][col] + helper(grid,row+1,col);
        }

        int take2=Integer.MAX_VALUE;

        if(col + 1 < m){
            take2=grid[row][col] + helper(grid,row,col+1);
        }

        return dp[row][col] = Math.min(take1,take2);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return helper(grid,0,0);
    }
}