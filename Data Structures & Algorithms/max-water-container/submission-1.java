class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int len=j-i;
                int minHeight=Math.min(heights[i],heights[j]);
                int area=minHeight * len;
                max=Math.max(area,max);
            }
        }
        return max;
    }
}
