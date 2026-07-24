class Solution {
    public static void helper(HashSet<ArrayList<Integer>> set,ArrayList<Integer> temp,int[] nums,
    int idx,int sum,int target){
        if(sum == target){
            ArrayList<Integer> t=new ArrayList<>(temp);
            Collections.sort(t);
            set.add(new ArrayList<>(t));
            return;
        }

        if(idx >= nums.length) return;
        //take it
        if(nums[idx] + sum <= target){
            temp.add(nums[idx]);
            helper(set,temp,nums,idx+1,sum+nums[idx],target);
            temp.remove(temp.size()-1);
        }

        //skip
        helper(set,temp,nums,idx+1,sum,target);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> set=new HashSet<>();

              helper(set,new  ArrayList<>(),candidates,0,0,target);
        return new ArrayList<>(set);
    }
}
