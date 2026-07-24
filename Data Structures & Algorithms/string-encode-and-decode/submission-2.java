class Solution {

    public String encode(List<String> strs) {
    StringBuilder str=new StringBuilder();

        for(int i=0;i<strs.size();i++){
            StringBuilder curr=new StringBuilder(strs.get(i));

            str.append(curr.length()).append('#').append(curr);
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> result=new ArrayList<>();
         int length=str.length();
      int idx=0;

      while(idx< length){
        int j=idx;
        while(str.charAt(j) != '#'){
            j++;
        }
        int len=Integer.parseInt(str.substring(idx,j));

        String curr=str.substring(j+1,j+1+len);

        result.add(curr);

        idx=j+1+len;
      }

      return result;
    
    }
}
