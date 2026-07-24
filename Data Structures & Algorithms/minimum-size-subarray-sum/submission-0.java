class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int len=Integer.MAX_VALUE;
        int sum=0;
        int n=nums.length;

        for(int ei=0;ei<n;ei++){
            sum+=nums[ei];

            while(sum >= target){
                len=Math.min(len,ei-si+1);
                sum-=nums[si];
                si++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}