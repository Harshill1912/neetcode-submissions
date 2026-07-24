class Solution {
    public boolean isAlienSorted(String[] words, String order) {
         int n = words.length;

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<order.length();i++) map.put(order.charAt(i),i);

        for(int i=0;i<n-1;i++){
            String s1=words[i];
            String s2=words[i+1];

            int min=Math.min(s1.length(),s2.length());
            int j=0;
            boolean check=false;
            for(j=0;j<min;j++){
            int idx1=map.get(s1.charAt(j));
            int idx2=map.get(s2.charAt(j));
               if(idx1 < idx2){
               check=true;
               break;
               } 
               else if(idx1 > idx2) return  false;
            }
            if(j < s1.length() && !check) return false;
        }

        return true;
    }
}