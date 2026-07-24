class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n-3;i++){
              if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
              if (j > i + 1 && nums[j - 1] == nums[j])  continue;
                int left=j+1;
                int right=n-1;

                while(left < right){
             long sum=(long)nums[i] + nums[j] + nums[left] + nums[right];

                if(sum == target){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                      temp.add(nums[j]);  
                      temp.add(nums[left]);  
                      temp.add(nums[right]);

                      result.add(temp);

                      left++;
                while( left < right  && nums[left] == nums[left-1]) left++; 
                      
                      right--;
               while(left < right && nums[right] == nums[right +1]) right--;
                } else if (sum > target) right--;
                else left++;

            }
            }
        }
        return result;
    }
}