class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int prod=1;

        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                cnt++;
            }else{
                prod*=nums[i];
            }
        }

        int[] ans=new int[n];

        if(cnt==0){
            for(int i=0;i<n;i++){
                int temp=prod;
                ans[i]=temp/nums[i];
            }
        }else if(cnt==1){
            for(int i=0;i<n;i++){
                if(nums[i] == 0){
                    ans[i]=prod;
                }
            }
        }

        return ans;
    }
}  
