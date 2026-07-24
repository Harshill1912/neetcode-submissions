class Solution {
    public static  boolean DFS(ArrayList<ArrayList<Integer>> adj,int node,int[] vis){
        vis[node]=1;

        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                if(!DFS(adj,it,vis)){
                    return false;
                }
            }else{
                return false;
            }
        }
         vis[node]=0;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

       for(int i=0;i<numCourses;i++){
         adj.add(new ArrayList<>());
       }       

        for(int i=0;i<prerequisites.length;i++){
        int u=prerequisites[i][0];
        int v=prerequisites[i][1];

            adj.get(v).add(u);
        }

        int[] vis=new int[numCourses];

        for(int i=0;i<numCourses;i++){
        if(!DFS(adj,i,vis)){
            return false;
        }
        }

        return true;
    }

}