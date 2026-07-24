class Solution {

    public static void helper(int[]  nums,int idx,int tar,Set<List<Integer>> set,ArrayList<Integer> list){
        if(idx <0) return;
      if(tar==0){
        set.add(new ArrayList<>(list));
        return;
      }
      if(nums[idx] <= tar){
        list.add(nums[idx]);
         helper(nums,idx,tar-nums[idx],set,list) ;
        list.remove(list.get(list.size()-1));

      }

       helper(nums,idx-1,tar,set,list);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> res=new HashSet<>();

        helper(nums,nums.length-1,target,res,new ArrayList<>());

         return  new ArrayList<>(res);
        }
}
