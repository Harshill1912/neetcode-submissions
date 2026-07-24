class Solution {
    static int[] dp;
    public static int helper(int[] nums,int n,int idx){
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take=nums[idx] + helper(nums,n,idx+2);
        int skip=helper(nums,n,idx+1);

        return dp[idx]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int take1=helper(nums,n-1,0);
        Arrays.fill(dp,-1);
        int skip1=helper(nums,n,1);

        return Math.max(take1,skip1);
    }
}
