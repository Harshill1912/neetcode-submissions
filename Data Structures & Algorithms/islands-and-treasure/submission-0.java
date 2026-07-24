class Solution {
    class Tuple{
        int first;
        int second;
        int steps;
        Tuple(int first,int second,int steps){
            this.first=first;
            this.second=second;
            this.steps=steps;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Tuple> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                     q.offer(new Tuple(i,j,0));
                }
            }
        }

        int[] rowdir={-1,0,1,0};
        int[] coldir={0,-1,0,1};

        while(!q.isEmpty()){
            Tuple curr=q.poll();
            int row=curr.first;
            int col=curr.second;
            int steps=curr.steps;
               
               for(int i=0;i<4;i++){
                int nrow=row+rowdir[i];
                int ncol=col+coldir[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==Integer.MAX_VALUE){
                    grid[nrow][ncol]=steps+1;
                    q.offer(new Tuple(nrow,ncol,steps+1));
                }
               }
        }

    }
}
