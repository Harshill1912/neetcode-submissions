class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                int height=heights[st.pop()];
                int width= st.isEmpty() ? i:(i-st.peek() -1);
                maxArea=Math.max(maxArea,height*width);
            }

            st.push(i);
        }

        while(!st.isEmpty()){
         int height=heights[st.pop()];
         int width= st.isEmpty() ? n:(n-st.peek() -1); 
             maxArea=Math.max(maxArea,height*width);
        }

        return maxArea;
    }
}
