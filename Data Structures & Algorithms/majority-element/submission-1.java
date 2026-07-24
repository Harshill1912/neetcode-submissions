class Solution {
    public int majorityElement(int[] nums) {
        int  n=nums.length;

        int cnt=0;
        int maj=0;

        for(int i=0;i<n;i++){
             if(cnt==0){
                maj=nums[i];
             }

             cnt+=(nums[i] == maj) ?  1:-1;
        }

        return maj;
    }
}