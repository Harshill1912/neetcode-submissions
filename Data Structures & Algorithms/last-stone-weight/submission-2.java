class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) pq.offer(stone);

         while(pq.size() > 1){
            int a=pq.poll();
            int b=pq.poll();

            if(a == b) continue;
            else pq.offer(a-b);
         }

         if(pq.size() > 0) return pq.peek();

         return 0;
    }
}
