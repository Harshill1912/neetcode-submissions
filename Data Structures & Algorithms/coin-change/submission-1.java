class Solution {
    public static  int helper(int[] coins,int amount,int idx){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(idx < 0 ) return Integer.MAX_VALUE;

          int take = helper(coins, amount - coins[idx], idx);
            if (take != Integer.MAX_VALUE) take += 1;

        int skip = helper(coins, amount, idx - 1);

        return Math.min(take, skip);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int ans=helper(coins,amount,coins.length-1);

        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}
