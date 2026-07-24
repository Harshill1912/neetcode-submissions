class Solution {
    static int[] dp;
    public static int helper(int[] nums,int idx){
        if(idx>=nums.length) return 0;
         if(dp[idx] != -1) return dp[idx];
        int take=nums[idx] + helper(nums,idx+2);
        int skip=helper(nums,idx+1);

        return dp[idx]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0);
    }
}
