class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str=new StringBuilder();

        int i=0;
        int j=0;
        int n=word1.length();
        int m=word2.length();
        int turn=0;
        while(i<n && j<m){
            if(turn % 2==0){
                str.append(word1.charAt(i));
                i++;
            }else{
                str.append(word2.charAt(j));
                j++;
            }
            turn++;
        }

        if(i<n){
            str.append(word1.substring(i,n));
        }

        if(j<m){
            str.append(word2.substring(j,m));
        }

        return str.toString();
    }
}