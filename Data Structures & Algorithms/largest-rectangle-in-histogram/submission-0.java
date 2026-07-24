class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int len=heights[i];
             maxArea=Math.max(len,maxArea);
            for(int j=i+1;j<n;j++){
                 len=Math.min(heights[j],len);
                 int area=len * (j-i+1);
                 maxArea=Math.max(area,maxArea);
            }
        }

        return maxArea;
    }
}
