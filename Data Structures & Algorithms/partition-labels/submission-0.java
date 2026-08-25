class Solution {
    public static boolean helper( HashMap<Character,Integer> map,HashMap<Character,Integer> map2){
        for(Map.Entry<Character,Integer> entry : map2.entrySet()){
            char ch=entry.getKey();
            int freq=entry.getValue();
            if(map.get(ch) != freq) return false;
        }

        return true;
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        int si=0;
        int n=s.length();
         
         HashMap<Character,Integer> map = new HashMap<>();

         for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
         }

         HashMap<Character,Integer> map2=new HashMap<>();

         for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);

            if(helper(map,map2)){
                list.add(i-si+1);
                si=i+1;
            }
         }

         return list;
    }
}
