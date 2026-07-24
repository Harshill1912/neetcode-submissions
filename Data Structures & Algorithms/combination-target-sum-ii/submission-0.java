class Solution {
    public static void helper(int[] arr,int idx,int tar, List<List<Integer>> res,ArrayList<Integer> list){

        if(tar==0){
            ArrayList<Integer> temp = new ArrayList<>(list);
           Collections.reverse(temp); 
              res.add(temp); 
              return;
        }

        if (idx < 0 || tar < 0) return;  

        if(arr[idx]<=tar){
            list.add(arr[idx]);
            helper(arr,idx-1,tar-arr[idx],res,list);
            list.remove(list.get(list.size()-1));
        }
       
       while(idx >0 && arr[idx]==arr[idx-1]){
        idx--;
       }
        

        helper(arr,idx-1,tar,res,list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);

        List<List<Integer>> res=new ArrayList<>();

        helper(candidates,candidates.length-1,target,res,new ArrayList<>());
         
         return res;
    }
}
