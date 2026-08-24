class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank=0;
        int totalCost=0;
        int n=gas.length;
        int idx=0;

        for(int i=0;i<n;i++){
            totalTank+=(gas[i] - cost[i]);
            totalCost+=(gas[i] - cost[i]);

            if(totalCost < 0){
                idx=i+1;
                totalCost=0;
            }
        }

        return totalTank < 0  ?   -1 : idx ;
    }
}
