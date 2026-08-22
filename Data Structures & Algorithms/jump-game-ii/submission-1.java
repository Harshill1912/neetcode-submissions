class Solution {
    public int jump(int[] nums) {
        int max=0;
        int jumps=0;
        int end=0;

        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,nums[i] + i);

            if(i == end){
                jumps++;
                end=max;
            }

          
        }

        return jumps;
    }
}
