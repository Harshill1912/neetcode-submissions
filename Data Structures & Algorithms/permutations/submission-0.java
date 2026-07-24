class Solution {
    public static void swap(int[] nums,int idx1,int idx2){
        int temp=nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }
public static void helper(List<List<Integer>> list,int[] nums,int idx){
      if(idx == nums.length){
         ArrayList<Integer> temp=new ArrayList<>();
         for(int num : nums) temp.add(num);
         list.add(temp);
         return;
      }

      for(int i=idx;i<nums.length;i++){
        swap(nums,i,idx);
        helper(list,nums,idx+1);
        swap(nums,i,idx);

      }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();

         helper(list,nums,0);

        return list;
    }
}
