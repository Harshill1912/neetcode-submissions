class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
          int start=0;
          int len=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            while(map.getOrDefault(s.charAt(i), 0) > 0){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }

           map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
           len=Math.max(len,i-start+1);

        }
        return len==Integer.MIN_VALUE ? 0:len ;
    }
}
