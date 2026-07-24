class Solution {
    public static int BFS(int[][] grid,int row,int col,int[][] vis){
        vis[row][col]=1;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        int perimeter=0;

        int[] dirRow={0,1,0,-1};
        int[] dirCol={-1,0,1,0};

        while(!q.isEmpty()){
             int[] curr=q.poll();
             int r=curr[0];
             int c=curr[1];
             int sides=4;

             for(int i=0;i<4;i++){
                int nRow=dirRow[i] + r;
                int nCol=dirCol[i] + c;
                if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length
                 && grid[nRow][nCol] ==1 ){
                    sides-=1;
                    if(vis[nRow][nCol] ==0){
                    q.offer(new int[]{nRow,nCol});
                    vis[nRow][nCol]=1;
                    }
                 }

             }
               perimeter+=sides;
        }
        return perimeter;
    }
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return BFS(grid,i,j,vis);
                }
            }
        }
        return 0;
    }
}