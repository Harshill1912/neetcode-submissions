class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash=new int[26];
        int n=s.length();
        int si=0;
        int maxF=0;
        int maxLen=0;

        for(int ei=0;ei<n;ei++){
            char ch=s.charAt(ei);
            hash[ch-'A']++;
            maxF=Math.max(maxF,hash[ch-'A']);

            while((ei-si+1) - maxF> k){
                hash[s.charAt(si) - 'A'] --;
                for(int i=0;i<26;i++){
                    maxF=Math.max(maxF,hash[i]);
                }
                si++;
            }

            maxLen=Math.max(maxLen,ei-si+1);
        }

        return maxLen;
    }
}
