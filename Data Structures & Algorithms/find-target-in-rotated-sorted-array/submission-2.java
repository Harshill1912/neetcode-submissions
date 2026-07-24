class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;
        while(si<=ei){
            int mi=si+(ei-si)/2;
            if(nums[mi]==target){
                return mi;
            }
            if(nums[mi]>=nums[si]){
                if(nums[si]<=target && nums[mi]>=target){
                    ei=mi-1;
                }else{
                    si=mi+1;
                }
            }else{
                if(nums[ei]>=target && nums[mi]<=target){
                    si=mi+1;
                }else{
                    ei=mi-1;
                }
            }
        }
        return -1;
    }
}