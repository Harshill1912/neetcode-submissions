class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> st=new Stack<>();

        for(int i=0;i<parts.length;i++){
            if(parts[i].equals("") || parts[i].equals(".")){
                continue;
            }

            if(parts[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(parts[i]);
            }
        }

         StringBuilder str=new StringBuilder();

         while(!st.isEmpty()){
            str.insert(0,"/"+st.pop());
         }

         return str.length() == 0 ? "/" : str.toString();
    }
}