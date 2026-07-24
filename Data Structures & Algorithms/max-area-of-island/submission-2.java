class Solution {
    public static int BFS(int[][] grid,int row,int col,int[][] vis){
        vis[row][col] = 1;

        Queue<int[]> q= new LinkedList<>();

        q.offer(new int[]{row,col});
        int area=1;

        int[] dirRow={1,0,-1,0};
        int[] dirCol={0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr =q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int i=0;i<4;i++){
             int nRow=r+dirRow[i];
             int nCol=c+dirCol[i];
            if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && vis[nRow][nCol]==0
            && grid[nRow][nCol] == 1){
                vis[nRow][nCol] = 1;
                q.offer(new int[]{nRow,nCol});
                area++;
            }
         }
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n =grid.length;
        int m=grid[0].length;

      int[][] vis=new int[n][m];
      int max=0;

      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
             if(grid[i][j] == 1 && vis[i][j] == 0){
                int ans=BFS(grid,i,j,vis);
                max=Math.max(max,ans);
             }
        }
      }

      return max;
    }
}
