class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int cnt=1;
        int len=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            int diff=nums[i]-nums[i-1];
            if(diff==1){
                cnt++;
            }else if(diff >1){
                len=Math.max(len,cnt);
                cnt=1;
            }
        }

        len=Math.max(cnt,len);

        return len;
    }
}
