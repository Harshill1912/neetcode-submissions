class Solution {
    static int[][] dp;
    public static int helper(int row,int col,int m ,int n){
        if(row == m && col == n) return 1;
        if( row > m || col > n || row < 0 || col < 0) return 0;

        if(dp[row][col] != -1) return dp[row][col];
        
        int take1=0;
        if(row + 1 <= m){
            take1=helper(row+1,col,m,n);
        }
        int take2=0;
        if(col + 1 <= n){
            take2=helper(row,col+1,m,n);
        }

        return dp[row][col] = take1+take2;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return helper(0,0,m-1,n-1);
    }
}
