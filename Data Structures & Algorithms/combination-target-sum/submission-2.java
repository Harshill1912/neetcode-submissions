class Solution {
    public static void  helper( List<List<Integer>> list, HashSet<ArrayList<Integer>> set,
    ArrayList<Integer> temp,int[] nums,int idx,int sum,int target){
        if(sum == target){
            ArrayList<Integer> t=new ArrayList<>(temp);
            if(!set.contains(t)){
                set.add(t);
                list.add(new ArrayList<>(t));
            }
        }

        if(idx >= nums.length) return;
          
        if(nums[idx] + sum <= target){
            temp.add(nums[idx]);
        helper(list,set,temp,nums,idx,sum+nums[idx],target);
         temp.remove(temp.size()-1);
        }
       
        if(nums[idx] + sum <= target){
            temp.add(nums[idx]);
            helper(list,set,temp,nums,idx+1,sum+nums[idx],target);
             temp.remove(temp.size()-1);
        }
         
        helper(list,set,temp,nums,idx+1,sum,target);
        


    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        HashSet<ArrayList<Integer>>set=new HashSet<>();

        helper(list,set,new ArrayList<>(),nums,0,0,target);


        return list;
    }
}
