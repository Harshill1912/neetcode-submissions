class Solution {
    class Pair{
        int node;
        int time;
       Pair(int node,int time){
        this.node=node;
        this.time=time;
       }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int len=times.length;
        int m=times[0].length;

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.time-b.time);

        int[] dist=new int[n+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        pq.offer(new Pair(k,0));


        while(pq.size() > 0){
          Pair curr=pq.poll();
          int node=curr.node;
          int time=curr.time;
        
         for( Pair it : adj.get(node)){
             int val=it.node;
             int cost=it.time;

             if(time + cost <= dist[val]){
                dist[val]=time + cost;
                pq.offer(new Pair(val,dist[val]));
             }
         }
        }

        int max=-1;

        for(int i=1;i<=n;i++){
            if(i != k){
                if(dist[i] == Integer.MAX_VALUE) return -1;
                max=Math.max(max,dist[i]);
            }
        }

        return max;

    }
}
