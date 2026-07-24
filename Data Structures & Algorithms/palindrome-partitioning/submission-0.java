class Solution {
    public static boolean palindrome(String s){
        int si=0;
        int ei=s.length()-1;
        while(si <= ei){
               if(s.charAt(si) != s.charAt(ei)) return false;
               si++;
               ei--;
        }
        return true;
    }
    public static void helper( List<List<String>> list,ArrayList<String> temp,String s,int idx){
        if(idx >= s.length()){
        if(temp.size() == 0) return ;
        list.add(new ArrayList<>(temp));
        return;
        }

        for(int i=idx;i<s.length();i++){
            String st=s.substring(idx,i+1);
            if(palindrome(st)) {
                temp.add(st);
                helper(list,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
          
        }
    }

    public List<List<String>> partition(String s) {
        int n=s.length();
        List<List<String>> list=new ArrayList<>();
           
           helper(list,new ArrayList<>(),s,0);

        return list;
    }
}
