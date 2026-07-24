class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int si=0;
        int ei=people.length-1;
        int boats=0;

        Arrays.sort(people);

        while(si<=ei){
            int sum=people[si] + people[ei];

            if(sum <= limit){
                boats++;
                si++;
                ei--;
            }else{
                boats++;
                ei--;
            }
        }
        return boats;
    }
}