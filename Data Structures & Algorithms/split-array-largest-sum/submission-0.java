class Solution {
    public static boolean helper(int[] arr,int mid,int k){
        int sum=0;
        int count=0;

         for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= mid){
                sum+=arr[i];
            }else{
                count++;
                sum=arr[i];
            }
         }
          count++;

          return count<=k;
    }
    public int splitArray(int[] nums, int k) {
        int max=-1;
        int sum=0;

         for(int num : nums){
            max=Math.max(num,max);
            sum+=num;
         }

         int si=max;
         int ei=sum;
         int ans=-1;

          while(si <= ei){
            int mi=si+(ei-si)/2;

            if(helper(nums,mi,k)){
                 ans=mi;
                 ei=mi-1;
            }else{
                si=mi+1;
            }
          }

          return ans;
    }
}