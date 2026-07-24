class Solution {
    static int[] dp;
    public static int helper(int n){
        if(n==1 || n==2) return 1;
        if(n==0) return 0;
         if(dp[n] != -1) return dp[n];

        return dp[n] = helper(n-1) + helper(n-2) + helper(n-3);
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}