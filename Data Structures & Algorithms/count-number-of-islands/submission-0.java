class Solution {
    public void DFS(char[][] arr,int[][] vis,int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m || arr[row][col]=='0' || vis[row][col]==1){
            return;
        }
        vis[row][col]=1;
        DFS(arr,vis,row+1,col,n,m);
        DFS(arr,vis,row-1,col,n,m);
        DFS(arr,vis,row,col+1,n,m);
        DFS(arr,vis,row,col-1,n,m);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        int island=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                DFS(grid,vis,i,j,n,m);
                island++;
                }
            }
        }
        return island;
    }
}
