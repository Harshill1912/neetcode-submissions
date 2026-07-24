class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        int maxLen=0;

        for(int num:set){

            if(!set.contains(num-1)){
                int currnum=num;
                int currlen=1;

                while(set.contains(currnum+1)){
                    currnum++;
                    currlen++;
                }

                maxLen=Math.max(currlen,maxLen);
            }
        }

        return maxLen;
    }
}
