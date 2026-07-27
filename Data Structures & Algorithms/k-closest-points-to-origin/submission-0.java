class Solution {
    public int[][] kClosest(int[][] points, int k) {
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[2]-a[2]);

         for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int sqr=x*x + y*y;

            pq.offer(new int[]{x,y,sqr});

            if(pq.size() > k) pq.poll();
         }

         int[][] result=new int[k][2];

         for(int i=0;i<k;i++){
            int[] curr=pq.poll();
            result[i][0]=curr[0];
            result[i][1]=curr[1];
         }

         return result;

    }
}
