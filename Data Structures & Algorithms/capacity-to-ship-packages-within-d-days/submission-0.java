class Solution {
    public static boolean helper(int[] arr,int cap,int tdays){
        int days = 0;
    int curr = 0;
    for (int i = 0; i < arr.length; i++) {
        if (curr + arr[i] <= cap) {
            curr += arr[i];
        } else {
            days++;
            curr = arr[i];
        }
    }
    days++; 
    return days <= tdays;
    }
    public int shipWithinDays(int[] weights, int days) {
    int max=-1;
    int sum=0;
      for(int i=0;i<weights.length;i++){
        max=Math.max(weights[i],max);
        sum+=weights[i];
      }
       int si=max;
       int ei=sum;
       int ans=-1;

        while(si<=ei){
         int mi=si+(ei-si)/2;
           
           if(helper(weights,mi,days)){
            ans=mi;
            ei=mi-1;
           }else{
            si=mi+1;
           }
        }
        return ans;
    }
}