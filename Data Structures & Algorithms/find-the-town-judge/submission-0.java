class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<trust.length;i++){
              if(set.isEmpty()) set.add(trust[i][1]);
              else if(!set.contains(trust[i][1])) return -1;
        }

        return trust[0][1];
    }
}