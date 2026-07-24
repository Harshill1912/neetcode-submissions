class Solution {
    public static void helper(HashSet<ArrayList<Integer>> set,ArrayList<Integer> temp,
    int[] nums,int idx){
        if(idx >= nums.length){
            set.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        helper(set,temp,nums,idx+1);
        temp.remove(temp.size()-1);
        helper(set,temp,nums,idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set=new HashSet<>();

         helper(set,new ArrayList<>(),nums,0);
        return new ArrayList<>(set);
    }
}
