class Solution {
    static int[][] dp;
    public static int helper(int[] nums,int idx,int last){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][last+1] != -1) return dp[idx][last+1];
        int take=0;
        if(last == -1 || nums[idx] > nums[last]){
            take=1+helper(nums,idx+1,idx);
        }

        int skip=helper(nums,idx+1,last);

        return dp[idx][last+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(nums,0,-1);
    }
}
