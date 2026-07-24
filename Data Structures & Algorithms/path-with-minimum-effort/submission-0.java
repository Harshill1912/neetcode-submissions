class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});

        int[][] dis=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][0]=0;

        int[] dirRow={1,0,-1,0};
        int[] dirCol={0,1,0,-1};

        while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int row=curr[0];
        int col=curr[1];
        int  effort=curr[2];

        if(row == n-1 && col==m-1){
            return effort;
        }

           for(int i=0;i<4;i++){
            int nRow=dirRow[i] + row;
            int nCol=dirCol[i] + col;

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m){
                int newEffort=Math.abs(heights[nRow][nCol] - heights[row][col]);
                newEffort=Math.max(newEffort,effort);
                if(newEffort < dis[nRow][nCol]){
                    dis[nRow][nCol]=newEffort;
                    pq.offer(new int[]{nRow,nCol,newEffort});
                }
            }
           }
        }

        return dis[n-1][m-1];
    }
}