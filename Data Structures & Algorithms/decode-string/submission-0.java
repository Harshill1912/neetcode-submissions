class Solution {
    public static int convert(StringBuilder s){
        int n=0;

        for(int i=0;i<s.length();i++){
             int  num=s.charAt(i) - '0';
             n=n*10+num;
        }
        return n;
    }
    public String decodeString(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();

        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            
        
            if(ch>='0'&& ch<='9'){
                continue;
            }

            if(ch=='['){
        
                StringBuilder str=new StringBuilder("");
                while(!st.isEmpty() && st.peek() != ']'){
                    str.append(st.pop());
                }
                st.pop();
                StringBuilder num=new StringBuilder();
                int x=i-1;
              
                 while(x >= 0 && s.charAt(x) >= '0' && s.charAt(x) <= '9'){
                num.append(s.charAt(x));
                    x--;
                }

                num.reverse();

                int k=convert(num);
                
              StringBuilder replaced=new StringBuilder("");

              for(int y=0;y<k;y++){
                replaced.append(str.substring(0,str.length()));
              }

              for(int j=replaced.length()-1;j>=0;j--){
                st.push(replaced.charAt(j));
              }
            }else{
                st.push(ch);
            }
        }

        StringBuilder result=new StringBuilder();

        while(!st.isEmpty()){
            result.append(st.pop());
        }

        return result.toString();
    }
}