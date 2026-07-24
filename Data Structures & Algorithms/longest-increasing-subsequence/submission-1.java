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
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
          
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int take=0;
                if( j== -1 || nums[i] > nums[j]){
                    take=1+dp[i+1][i+1];
                }
                int skip=dp[i+1][j+1];
                dp[i][j+1]=Math.max(take,skip);
                
            }
        }

        return dp[0][0];
    }
}
