class Solution {
    public int maxArea(int[] heights) {
        int si=0;
        int ei=heights.length-1;
        int max=Integer.MIN_VALUE;

         while(si < ei){
            int area= (ei-si) * Math.min(heights[si],heights[ei]);
            max=Math.max(area,max);

            if(heights[si] < heights[ei]) si++;
            else ei--;
         }
         return max;
    }
}
