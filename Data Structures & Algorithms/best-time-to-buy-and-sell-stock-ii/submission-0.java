class Solution {
    static int[][]dp;
    public static int helper(int[] arr,int idx,int buy){
        if(idx>=arr.length){
            return  0;
        }
        if(dp[idx][buy] !=-1){
            return dp[idx][buy];
        }
        int profit=0;

        if(buy==0){
            int currbuy=-arr[idx]+helper(arr,idx+1,1);
            int skipCurr=helper(arr,idx+1,0);
            profit=Math.max(currbuy,skipCurr);
        }else{
            int currSale=arr[idx]+helper(arr,idx+1,0);
            int skip=helper(arr,idx+1,1);
            profit=Math.max(currSale,skip);
        }

        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][2];

        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

         return helper(prices,0,0);
    }
}