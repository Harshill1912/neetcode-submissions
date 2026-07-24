class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int si=0;
        int ei=n-1;

        while(si<=ei){
            int mi=si+(ei-si)/2;

            if(nums[mi] == target) return mi;

            if(nums[mi] < target){
                si=mi+1;
            }else{
                ei=mi-1;
            }
        }
        return si;
    }
}