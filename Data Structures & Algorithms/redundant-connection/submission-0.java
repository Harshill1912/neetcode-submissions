class Solution {
    class DisjoinSet{
        ArrayList<Integer> par;
        ArrayList<Integer> rank;

      public DisjoinSet(int n){
        par=new ArrayList<>();
        rank=new ArrayList<>();
        for(int i=0;i<=n;i++){
            par.add(i);
            rank.add(0);
        }
      }

       void union(int u,int v){
        int upu=findParent(u);
        int upv=findParent(v);
          
          if(rank.get(upu) < rank.get(upv)){
            par.set(upv,upu);
          }else if(rank.get(upv) < rank.get(upu)){
            par.set(upv,upu);
          }else{
            par.set(upu,upv);
            rank.set(upu,rank.get(upu)+1);

          }
       }

       int findParent(int node){
        if(node == par.get(node)){
            return node;
        }

        int parent=findParent(par.get(node));
        par.set(node,parent);

        return par.get(node);
    
       }
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        int n=edges.length;

        DisjoinSet ds=new DisjoinSet(n);

        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findParent(u) == ds.findParent(v)){
                return new int[]{u,v};
            }else{
                ds.union(u,v);
            }
        }

        return new int[]{-1,-1};
    }
}
