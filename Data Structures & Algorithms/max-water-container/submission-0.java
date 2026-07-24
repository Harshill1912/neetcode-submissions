class Solution {
    public int maxArea(int[] heights) {
    int si=0;
    int ei=heights.length-1;
    int ans=Integer.MIN_VALUE;
    while(si<ei){
     int temp=Math.min(heights[si],heights[ei]);
     ans=Math.max(ans,temp*(ei-si));
     if(heights[si]<heights[ei]){
        si++;
     }else{
        ei--;
     }
    }
    return ans;
    }
}
