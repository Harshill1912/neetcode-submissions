class Solution {
    public static int helper(int[] nums,int xor,int idx){
        if (idx >= nums.length) return xor;

        int take=helper(nums,xor ^ nums[idx],idx+1);

        int skip=helper(nums,xor,idx+1);

        return take + skip;
    }
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
}