class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
    int n=triplets.length;
    boolean a=false;
    boolean b=false;
    boolean c=false;
    int maxA=Integer.MIN_VALUE;
    int maxB=Integer.MIN_VALUE;
    int maxC=Integer.MIN_VALUE;

    for(int i=0;i<n;i++){
        if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]){
            continue;
        }
      if(triplets[i][0] == target[0]) a = true;
       if(triplets[i][1] == target[1]) b = true;
        if(triplets[i][2] == target[2]) c = true;

    }

   if(a && b && c) return true;

   return false;
    
    }
}
