class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)  q.offer(new int[]{i,j});
            }
        }

           int cnt=0;
           int[] dirrow={-1,0,1,0};
           int[] dircol={0,1,0,-1};

        while(!q.isEmpty()){
           
           boolean rooted=false;
           int size=q.size();

          for(int j=0;j<size;j++){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];

            for(int i=0;i<4;i++){
                int nrow=row+dirrow[i];
                int ncol=col+dircol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                rooted=true;
                grid[nrow][ncol]=2;
                q.offer(new int[]{nrow,ncol});
            }
         }
       }
          
           if(rooted) cnt++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return cnt;

    }
}
