class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(!Character.isLetterOrDigit(ch)) continue;
        if(Character.isUpperCase(ch)){
            ch=Character.toLowerCase(ch);
        }
        str.append(ch);
        }

       StringBuilder rev = new StringBuilder(str).reverse();
    
    return str.toString().equals(rev.toString());
    }
}
