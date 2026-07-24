class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

          List<Integer> ans=new ArrayList<>();
          int maj=n/3;

          for(Map.Entry<Integer,Integer> entry : map.entrySet()){
               int freq=entry.getValue();

               if(freq > maj){
                ans.add(entry.getKey());
               }
          } 

          return ans;
    }
}