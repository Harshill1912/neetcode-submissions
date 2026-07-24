class Solution {
    public static void helper( List<List<Integer>> list,ArrayList<Integer> temp,int num,
    int k,int n){
        if(temp.size() == k){
            list.add(new ArrayList<>(temp));
            return;
        }

        if(num > n) return;

        //take 
        temp.add(num);
        helper(list,temp,num+1,k,n);
        temp.remove(temp.size()-1);

        //skip
        helper(list,temp,num+1,k,n);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();

         helper(list,new ArrayList<>(),1,k,n);

        return list;
    }
}