class Solution {
   
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
         Queue<int[]> q= new LinkedList<>();

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                  q.offer(new int[]{i,j,0});
                }
            }
         }

         int[] dirRow={0,1,0,-1};
        int[] dirCol={1,0,-1,0};

        while(!q.isEmpty()){
          int [] curr=q.poll();
          int r=curr[0];
          int c=curr[1];
          int stps=curr[2];

          for(int i=0;i<4;i++){
            int nRow=dirRow[i] + r;
            int nCol=dirCol[i] + c;
            if(nRow>=0 && nRow < grid.length && nCol>=0 && nCol<grid[0].length
            && grid[nRow][nCol] != -1){
                   if(grid[nRow][nCol] >= stps+1){
                    grid[nRow][nCol] = stps+1;
                    q.offer(new int[]{nRow,nCol,stps+1});
                   }
            }
          }
        }
    }
}
