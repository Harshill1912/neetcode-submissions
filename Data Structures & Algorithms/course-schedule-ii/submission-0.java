class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        int idx=0;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        int[] indegree=new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            result[idx]=node;
            idx++;

            for(Integer it : adj.get(node)){
                indegree[it] --;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(idx < numCourses) return new int[]{};

        return result;
    }
}
