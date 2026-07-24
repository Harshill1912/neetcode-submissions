class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.second - y.second);
             
        pq.offer(new Pair(k,0));
        int [] dis=new int[n+1];

        for(int i=1;i<dis.length;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[k]=0;

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.first;
            int time=curr.second;

            for(Pair it:adj.get(node)){
                int adjNode=it.first;
                int adjTime=it.second;

                if(adjTime+time <dis[adjNode]){
                    dis[adjNode]=adjTime+time;
                    pq.offer(new Pair(adjNode,dis[adjNode]));
                }
            }
        }
        int ans=Integer.MIN_VALUE;

        for(int i=1;i<dis.length;i++){
         ans=Math.max(ans,dis[i]);
        }

        if(ans==Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }
}