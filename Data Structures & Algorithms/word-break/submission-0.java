class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        int maxLen=0;

        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
            maxLen=Math.max(wordDict.get(i).length(),maxLen);
        }

        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;

        for(int i=0;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
