class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen=0;
        int currLen=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] - nums[i-1] == 1) currLen++;
            else{
                maxLen=Math.max(currLen,maxLen);
                currLen=1;
            }
        }
         maxLen=Math.max(currLen,maxLen);
        return maxLen;
    }
}
