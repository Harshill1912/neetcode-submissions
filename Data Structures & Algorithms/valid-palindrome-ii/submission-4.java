class Solution {
    public static boolean helper(String s,int si,int ei,int count){
         if (si >= ei) {
            return true;
        }

        if (s.charAt(si) != s.charAt(ei)) {
            if (count == 0) {
                return false;
            }
            
            return helper(s, si + 1, ei, 0) || helper(s, si, ei - 1, 0);
        }

       
        return helper(s, si + 1, ei - 1, count);
    }
    public boolean validPalindrome(String s) {
        
        return helper(s,0,s.length()-1,1);
    }
}