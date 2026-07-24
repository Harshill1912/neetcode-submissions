class Solution {
    public static void helper(List<List<Integer>> list,ArrayList<Integer> temp,int[] nums,int idx){
        if(idx >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        //take it
        temp.add(nums[idx]);
        helper(list,temp,nums,idx+1);

        //backtrack
        temp.remove(temp.size()-1);

        //call again
        helper(list,temp,nums,idx+1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();

        helper(list,new ArrayList<>(),nums,0);

        return list;
    }
}
