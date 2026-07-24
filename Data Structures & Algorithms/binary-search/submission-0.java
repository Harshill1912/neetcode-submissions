class Solution {
    public int search(int[] nums, int target) {
        int si=0;
        int ei=nums.length-1;

        while(si <= ei){
            int mi = si + (ei - si) / 2;
             
             if(nums[mi] == target ) return mi;

             if(nums[mi] > target) ei=mi-1;
             else si=mi+1;
        }
        return -1;
    }
}
