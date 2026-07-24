class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;

        Arrays.sort(strs);

        String str1=new String(strs[0]);
        String str2=new String(strs[n-1]);

        StringBuilder result=new StringBuilder("");

        for(int i=0;i<str1.length();i++){
              if(str1.charAt(i) != str2.charAt(i)){
                return result.toString();
              }
            result.append(str1.charAt(i));
        }

        return result.toString();
    }
}