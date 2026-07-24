class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     int[] indegree=new int[numCourses];
     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

      for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

      for(int i=0;i<prerequisites.length;i++){
        int u=prerequisites[i][0];
        int v=prerequisites[i][1];
        adj.get(v).add(u);
        indegree[u]++;
      }   

      Queue<Integer> q=new LinkedList<>();
      int idx=0;
      
      for(int i=0;i<numCourses;i++){
        if(indegree[i] == 0) q.offer(i);
      }

      while(!q.isEmpty()){
        int node=q.poll();

        for(Integer it : adj.get(node)){
            indegree[it]--;
            if(indegree[it] == 0) q.offer(it);
        }

        idx++;
      }

      return idx==numCourses;

    }
}
