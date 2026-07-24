class Solution {
        // Helper function to perform DFS and check for cycles and connectivity
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int parent) {
        vis[node] = 1;
        
        // Explore all the adjacent nodes
        for (Integer neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {  // If the neighbor hasn't been visited yet
                if (dfs(neighbor, adj, vis, node)) {
                    return true;  // Found a cycle
                }
            } else if (neighbor != parent) {  // If the neighbor is visited and is not the parent, it's a cycle
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
  if (edges.length != n - 1) {
            return false;
        }
        
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Visited array to track which nodes are visited
        int[] vis = new int[n];
        
        // Perform DFS from node 0
        if (dfs(0, adj, vis, -1)) {
            return false;  // If DFS finds a cycle, return false
        }
        
        // Check if all nodes are visited (the graph must be connected)
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                return false;  // If any node is not visited, the graph is not connected
            }
        }
        
        return true; 
    }
}
