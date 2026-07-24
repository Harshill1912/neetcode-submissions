class Solution {
    static int[] dp;
    public static int helper(int[] nums,int si,int ei){
    int prev2=0;
    int prev1=0;

    for(int i=si;i<=ei;i++){
        int rob=nums[i] + prev2;
        int skip=prev1;
        int curr=Math.max(rob,skip);

        prev2=prev1;
        prev1=curr;
    }

    return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        if(n==2) return Math.max(nums[0],nums[1]);
        int take1=helper(nums,0,n-2);
        int skip1=helper(nums,1,n-1);

        return Math.max(take1,skip1);
    }
}
