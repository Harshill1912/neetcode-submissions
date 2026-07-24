class Solution {
  
    public static void merge(int[] arr,int si,int mi,int ei){
        ArrayList<Integer> list=new ArrayList<>();
        int left=si;
        int right=mi+1;

        while(left<=mi && right<=ei){
            if(arr[left] < arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while(left<=mi){
            list.add(arr[left]);
            left++;
        }

        while(right<=ei){
        list.add(arr[right]);
         right++;
        }

        for(int i=0;i<list.size();i++){
               arr[si+i]=list.get(i);
        }
    }
    public static void mergeSort(int[] nums,int si,int ei){
        if(si>=ei) return;
          
        int mi=si+(ei-si)/2;
        mergeSort(nums,si,mi);
        mergeSort(nums,mi+1,ei);
          
        merge(nums,si,mi,ei);

    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
     
        mergeSort(nums,0,n-1);

        return nums;
    }
}