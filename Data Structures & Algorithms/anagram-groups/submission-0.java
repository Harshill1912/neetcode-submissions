class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>();

         for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String st=new String(arr);

            if(!map.containsKey(st)){
                ArrayList<String> temp=new ArrayList<>();
                temp.add(str);
                map.put(st,temp);
            }else{
                map.get(st).add(str);
            }
        }

        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            ArrayList<String> list=new ArrayList<>(entry.getValue());
            
            result.add(list);
        }

        return result;
    }
}
