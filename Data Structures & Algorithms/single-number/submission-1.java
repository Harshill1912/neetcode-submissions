class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        if(n>=2 && nums[n-1]!=nums[n-2]) return nums[n-1];
        return -1;
    }
}
