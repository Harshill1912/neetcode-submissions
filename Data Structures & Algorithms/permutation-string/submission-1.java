class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[] hash=new int[26];
       int n1=s1.length();
       int n2=s2.length();
    

       for(int i=0;i<n1;i++){
             hash[s1.charAt(i) - 'a']++;
       } 

       for(int i=0;i<=n2-n1;i++){
        if(hash[s2.charAt(i) - 'a'] > 0){
            String str=s2.substring(i,i+n1);
            int[] h=new int[26];
            for(int j=0;j<str.length();j++){
                h[str.charAt(j) - 'a']++;
            }
            boolean isExist=true;
            for(int k=0;k<26;k++){
                if(hash[k] != h[k]) {
                    isExist=false;
                    break;
                }
            }
            if(isExist) return true;
        }
       }
       return false;
    }
}
