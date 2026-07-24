class Solution {
    static int[] dp;
    public static int helper(int n){
        if(n==1 || n==0){
            return 1;
        }

        if(dp[n] != -1) return dp[n];

        return helper(n-1) + helper(n-2);
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}
