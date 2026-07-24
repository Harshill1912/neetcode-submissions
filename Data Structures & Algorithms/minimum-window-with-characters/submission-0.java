class Solution {
    public String minWindow(String s, String t) {
          int n=s.length();
        int m=t.length();

        int [] seen=new int[256];

        for(int i=0;i<m;i++){
        seen[t.charAt(i)]++;
        }
        
        int start=0;
        int minlen=Integer.MAX_VALUE;
        int cnt=0;
       int startidx=-1;

     for(int end=0;end<n;end++){
       if(seen[s.charAt(end)]>0){
            cnt++;
       } 
        seen[s.charAt(end)]--;

       while(cnt==m){
        if(end-start+1<minlen){
            minlen=end-start+1;
            startidx=start;
        }
        seen[s.charAt(start)]++;
        if(seen[s.charAt(start)]>0) cnt--;
        start++;
           }

     }
       return startidx == -1 ? "" : s.substring(startidx, startidx + minlen);
    }
}
