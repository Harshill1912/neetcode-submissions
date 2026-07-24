class Solution {
    public static void merge(int[] nums,int si,int mi,int ei){
        ArrayList<Integer> list=new ArrayList<>();
        int left=si;
        int right=mi+1;

        while(left<= mi && right<=ei){
            if(nums[left] < nums[right]){
                list.add(nums[left]);
                left++;
            }else{
                list.add(nums[right]);
                right++;
            }
        }

           while(left <= mi){
            list.add(nums[left]);
            left++;
           }
           while(right <= ei){
              list.add(nums[right]);
            right++;
           }

           for(int i=0;i<list.size();i++){
            nums[i+si]=list.get(i);
           }
    }
    public static void mergeSort(int [] nums,int si,int ei){
        if(si>=ei) return;

        int mi=si+(ei-si)/2;
        mergeSort(nums,si,mi);
        mergeSort(nums,mi+1,ei);
        merge(nums,si,mi,ei);
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int si=0;
        int ei=n-1;

        mergeSort(nums,si,ei);

        return nums;
    }
}