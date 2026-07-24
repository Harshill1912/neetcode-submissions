class Solution {
    public static int helper(ArrayList<ArrayList<Integer>> adj,int node){
        int[] vis=new int[adj.size()];
        vis[node]=1;

        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        int ht=0;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int val=q.poll();
                for(Integer it : adj.get(val)){
                    if(vis[it] == 0){
                        q.offer(it);
                        vis[it]=1;
                    }
                }
            }
            ht++;
        }
        return ht-1;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int ans=helper(adj,i);
            if(map.containsKey(ans)){
                map.get(ans).add(i);
            }else{
                List<Integer> t=new ArrayList<>();
                t.add(i);
                map.put(ans,t);
            }
            min=Math.min(min,ans);
        }

        return map.get(min);
    }
}