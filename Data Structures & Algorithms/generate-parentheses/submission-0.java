class Solution {
    static HashSet<String> set;
    public static void helper(StringBuilder str,int open,int close){

        if(open == 0 && close == 0){
            set.add(str.toString());
            return;
        }

        if(open > 0){
            str.append('(');
            helper(str,open-1,close);
              str.deleteCharAt(str.length() - 1);
        }
        if(close > 0 && open < close){
            str.append(')');
            helper(str,open,close-1);
            str.deleteCharAt(str.length() - 1); 
            
        }

      
        
        
    }
    public List<String> generateParenthesis(int n) {
        set=new HashSet<>();

        helper(new StringBuilder(),n,n);

        List<String> result=new ArrayList<>(set);

        return result;
    }
}
