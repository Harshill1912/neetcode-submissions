class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : hand) map.put(num,map.getOrDefault(num,0)+1);

        for(int i=0;i<n;i++){
            int num=hand[i];
            if(map.get(num) > 0){
                for(int j=num;j<num+groupSize;j++){
                    if(!map.containsKey(j) || map.get(j) == 0){
                        return false;
                    }else{
                        map.put(j,map.get(j)-1);
                    }
                }
            }
        }

        return true;
    }
}
