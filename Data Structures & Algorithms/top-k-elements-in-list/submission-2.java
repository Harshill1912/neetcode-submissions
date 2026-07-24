
class Solution {
    class Pair{
        int value;
        int freq;

        Pair(int value,int freq){
              this.value=value;
              this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];

         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.freq-b.freq);

         HashMap<Integer,Integer> map=new HashMap<>();

          for(int i=0;i<nums.length;i++){
              map.put(nums[i],map.getOrDefault(nums[i],0)+1);
          }

          for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val=entry.getKey();
            int freq=entry.getValue();
            pq.offer(new Pair(val,freq));

            if(pq.size() > k){
                pq.poll();
            }
          }


           int idx=0;
          while(!pq.isEmpty()){
            ans[idx++]=pq.poll().value;
            
          }
          
          return ans;
    }
}
