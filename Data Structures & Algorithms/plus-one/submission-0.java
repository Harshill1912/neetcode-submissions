class Solution {
    public int[] plusOne(int[] digits) {
        long num=0;
        for(int i=0;i<digits.length;i++){
            num=num*10+digits[i];
        }
        num++;
        ArrayList<Integer> list=new ArrayList<>();
        while(num>0){
            int rem = (int)(num % 10); 
            list.add(0, rem); 
            num = num / 10;
        }
         int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }
}
