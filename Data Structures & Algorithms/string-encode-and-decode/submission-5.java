class Solution {

    public String encode(List<String> strs) {
      StringBuilder str=new StringBuilder();

      for(int i=0;i<strs.size();i++){
        str.append(strs.get(i));
        str.append('~');
      }

      return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        int i=0;

        while(i<str.length()){
         int idx=i;
        StringBuilder sb=new StringBuilder();
          while(str.charAt(idx) != '~' && idx<str.length()){
                sb.append(str.charAt(idx));
                idx++;
          }
          list.add(sb.toString());
          i=idx+1;
        }

        return list;

    }
}
