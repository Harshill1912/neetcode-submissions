class Solution {

    public static void helper( List<String> result,StringBuilder st,HashMap<Integer,String> map,
    String dig,int idx){
        if(idx >= dig.length()){
            result.add(st.toString());
            return;
        }

        String str=map.get(dig.charAt(idx)-'0');

        for(int i=0;i<str.length();i++){
            st.append(str.charAt(i));
            helper(result,st,map,dig,idx+1);
            st.deleteCharAt(st.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0) return result;

        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
         map.put(4,"ghi");
          map.put(5,"jkl");
           map.put(6,"mno");
         map.put(7,"pqrs");
          map.put(8,"tuv");
           map.put(9,"wxyz");
         
         helper(result,new StringBuilder(),map,digits,0);


        return result;
    }
}
