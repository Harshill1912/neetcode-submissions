class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int si=0;
        int maxLen=0;

        for(int i=0;i<n;i++){
             char ch=s.charAt(i);
            while(map.containsKey(ch)){
                map.put(s.charAt(si),map.get(s.charAt(si))-1);
                if(map.get(s.charAt(si)) == 0) map.remove(s.charAt(si));
                si++;
            }
          
            maxLen=Math.max(maxLen,i-si+1);
             
             map.put(ch,map.getOrDefault(ch,0)+1);
        }

        return maxLen;
    }
}
