class Solution {

public static boolean canWeEat(int[] arr,int k,int h){
     int cnt=0;
      
       for(int i=0;i<arr.length;i++){
        double ans=(double)arr[i]/k;
        cnt+=Math.ceil(ans);
       }

    return cnt <= h;
} 
    public int minEatingSpeed(int[] piles, int h) {
        int max=-1;
        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i],max);
        }

        int si=1;
        int ei=max;
        int ans=-1;

         while(si<=ei){
            int mi=si+(ei-si)/2;
            
             if(canWeEat(piles,mi,h)){
                ans=mi;
                ei=mi-1;
             }else{
                si=mi+1;
             }
         }
         return ans;
    }
}
