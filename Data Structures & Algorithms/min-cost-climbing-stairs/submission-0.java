class Solution {
    public static int helper(int[] cost,int idx){
        if(idx >= cost.length){
            return 0;
        }

        int take1=cost[idx] + helper(cost,idx+1);
        int take2=cost[idx]+helper(cost,idx+2);

        return Math.min(take1,take2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int ans1=helper(cost,0);
        int ans2=helper(cost,1);

        return Math.min(ans1,ans2);
    }
}
