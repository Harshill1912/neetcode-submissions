class Solution {
    public static Boolean helper(ArrayList<ArrayList<Integer>> adj,int src,int dst){
        int[] vis=new int[adj.size()];
        vis[src] = 1;

        Queue<Integer> q=new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()){
            int node=q.poll();

            if(node == dst) return true;

            for(Integer it : adj.get(node)){
                if(vis[it] == 0){
                    vis[it] =1;
                    q.offer(it);
                }
            }
        }

        return false;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            adj.get(u).add(v);
        }

        List<Boolean> result=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            int src=queries[i][0];
            int dst=queries[i][1];

            if(helper(adj,src,dst)){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }
}