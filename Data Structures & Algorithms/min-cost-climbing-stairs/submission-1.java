class Solution {
    public static int helper(int[] cost,int idx,int[] dp){
        if(idx >= cost.length){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int take1=cost[idx] + helper(cost,idx+1,dp);
        int take2=cost[idx]+helper(cost,idx+2,dp);

        return dp[idx]=Math.min(take1,take2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp1=new int[cost.length];
        int[] dp2=new int [cost.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int ans1=helper(cost,0,dp1);
        int ans2=helper(cost,1,dp2);

        return Math.min(ans1,ans2);
    }
}
