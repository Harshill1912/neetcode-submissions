class Solution {
    static int count;
    public static boolean isPalindrome(String s,int si,int ei){
        while(si<=ei){
            if(s.charAt(si) != s.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }
    public static void helper(String s,int idx){
      if(idx >= s.length()) return;

      for(int i=idx;i<s.length();i++){
           if(isPalindrome(s,idx,i)){
            count++;
           }
      }
          helper(s,idx+1);
    }
    public int countSubstrings(String s) {
        count=0;
        helper(s,0);

        return count;
    }
}
