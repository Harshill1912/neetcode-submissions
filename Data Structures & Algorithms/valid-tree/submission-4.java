class Solution {
    public static boolean DFS(ArrayList<ArrayList<Integer>> adj,int node,int par,int[] vis){
        vis[node]=1;

        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                if(DFS(adj,it,node,vis)){
                    return true;
                }
            }else if(it != par){
                return true;
            }
        }

        return false;
    }
    public boolean validTree(int n, int[][] edges) {
       if (edges.length != n - 1) {
            return false;
        }
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());

       for(int i=0;i<edges.length;i++){
        adj.get(edges[i][0]).add(edges[i][1]);
        adj.get(edges[i][1]).add(edges[i][0]);
       }

       int[] vis=new int[n];

       if(DFS(adj,0,-1,vis)){
         return false;
       }

       for(int i=0;i<n;i++){ 
        if(vis[i] == 0){
             return false;
        }
       }
       return  true;
    }
}
