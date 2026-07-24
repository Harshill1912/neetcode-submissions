class Solution {
    static int[][] dp;
    public static boolean helper(int[] nums,int idx,int sum,int tar){
        if(sum == tar) return true;
        if(sum > tar || idx == nums.length) return false;

        if(dp[idx][sum] != -1){
            return dp[idx][sum] == 1 ? true : false;
        }

         if(helper(nums,idx+1,sum+nums[idx],tar) || helper(nums,idx+1,sum,tar)){
            dp[idx][sum]=1;
         }else{
            dp[idx][sum]=0;
         }

         return dp[idx][sum] == 1 ? true : false;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        
        for(int num : nums) sum+=num;

        if(sum % 2 == 1) return false;

         dp=new int[n+1][sum+1];

        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        return helper(nums,0,0,sum/2);
    }
}
