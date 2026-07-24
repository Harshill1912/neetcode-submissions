class Solution {
    public static void swap(int[] arr,int si,int ei){
        int temp=arr[si];
        arr[si]=arr[ei];
        arr[ei]=temp;
    }
    public static void helper(HashSet<ArrayList<Integer>> set,int[] nums,
    int idx){
        if( idx >= nums.length){
            ArrayList<Integer> list=new ArrayList<>();
            for(int num : nums) list.add(num);
            set.add(new ArrayList<>(list));
        }

        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            helper(set,nums,idx+1);
            swap(nums,idx,i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<ArrayList<Integer>> set=new HashSet<>();

              helper(set,nums,0);
        return new ArrayList<>(set);
    }
}