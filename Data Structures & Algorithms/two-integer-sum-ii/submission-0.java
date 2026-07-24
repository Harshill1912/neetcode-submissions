class Solution {
    public int[] twoSum(int[] numbers, int target) {
     int si=0;
     int ei=numbers.length-1;

               while(si < ei){
                int sum=numbers[si] + numbers[ei];

                  if(sum==target){
                    return new int[]{si+1,ei+1};
                  }else if(sum > target){
                    ei--;
                  }else{
                    si++;
                  }
               }

               return new int[]{-1,-1};
    }
}
