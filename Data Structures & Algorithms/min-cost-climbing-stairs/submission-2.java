class Solution {
    public static int helper(int[] cost,int idx){
      int n=cost.length;
       int[] dp=new int[n];

       dp[idx]= cost[idx];
       if(idx == 1) dp[0]=Integer.MAX_VALUE;


       for(int i=idx+1;i<n;i++){
        if(i>=2)dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        else dp[i]=cost[i];
       }
       return Math.min(dp[n-1],dp[n-2]);
    }
    public int minCostClimbingStairs(int[] cost) {
      
        int ans1=helper(cost,0);
        int ans2=helper(cost,1);

        return Math.min(ans1,ans2);
    }
}
