class Solution {
    public void sortColors(int[] nums) {
        int si=0;
        int ei=nums.length-1;
        int mi=0;

        while(mi<=ei){
            if(nums[mi] == 1){
                mi++;
            }else if(nums[mi] == 0){
                int temp=nums[si];
                nums[si]=nums[mi];
                nums[mi]=temp;
                si++;
                mi++;
            }else{
                int temp=nums[ei];
                nums[ei]=nums[mi];
                nums[mi]=temp;
                ei--;
            }
        }
    }
}