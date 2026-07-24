class Solution {
    static int[][] dp;
   public static int helper(int n, int num, int k) {
        
        if (n == 0) {
            return k >= 2 ? 1 : 0; 
        }
        if(num > n) return 0;
        if (n < 0) return 0;

        if(dp[n][num] != -1) return dp[n][num];

        int take1 = 0;
        if (num <= n) take1 = num * helper(n - num, num, k + 1);

        int take2 = 0;
        if (num <= n) take2 = num * helper(n - num, num + 1, k + 1);

        int skip = helper(n, num + 1, k);

        return  dp[n][num]=Math.max(take1, Math.max(take2, skip));
    }

    public int integerBreak(int n) {
        dp=new int[n+1][n+1];
       for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
    
        return helper(n,1,0);
    }
}