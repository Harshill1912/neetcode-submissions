class Solution {
    public static int DFS(int[][] grid,int row,int col,int n,int m){
        if(row>=n || row<0 || col>=m || col<0 || grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
      return 1 + DFS(grid, row + 1, col, n, m) 
             + DFS(grid, row - 1, col, n, m) 
             + DFS(grid, row, col + 1, n, m) 
             + DFS(grid, row, col - 1, n, m);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(grid[i][j]==1){
                int ans=DFS(grid,i,j,n,m);
                maxArea=Math.max(ans,maxArea);
              }
            }
        }
        return maxArea==Integer.MIN_VALUE ? 0 :maxArea;
    }
}
