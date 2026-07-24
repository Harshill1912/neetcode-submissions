class Solution {
    class Pair{
        int value;
        int diff;
    Pair(int value,int diff){
        this.value=value;
        this.diff=diff;
    }
}
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff) {
                return b.diff - a.diff; 
            } else {
                return b.value - a.value; 
            }
        });

       for(int i=0;i<n;i++){
         int diff=Math.abs(arr[i] - x);
         pq.offer(new Pair(arr[i] , diff));

         if(pq.size() > k){
            pq.poll();
         }
       }

       List<Integer> list=new ArrayList<>();

       while(!pq.isEmpty()){
        list.add(pq.poll().value);
       }

     Collections.sort(list);

     return list;
    }
}