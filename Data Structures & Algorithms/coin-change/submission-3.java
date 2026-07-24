class Solution {
    static int[][] dp;
    public static  int helper(int[] coins,int amount,int idx){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(idx < 0 ) return Integer.MAX_VALUE;

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take1 = helper(coins, amount - coins[idx], idx);
        if (take1 != Integer.MAX_VALUE) take1 += 1;

      
        int take2 = helper(coins, amount - coins[idx], idx - 1);
        if (take2 != Integer.MAX_VALUE) take2 += 1;

        int skip = helper(coins, amount, idx - 1);

        return  dp[idx][amount]=Math.min(skip, Math.min(take1, take2));
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i],-1);

        int ans=helper(coins,amount,coins.length-1);

        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}
