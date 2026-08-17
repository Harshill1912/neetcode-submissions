class Node{
    Node[] links = new Node[26];
    boolean isEnd=false;

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch,Node node){
        links[ch-'a'] = node;
    }

    void setEnd(){
        isEnd=true;
    }

    boolean isEnd(){
        return isEnd;
    }

    boolean isEmpty(){
        for(int i=0;i<26;i++){
           if(links[i]  != null)  return false;
        }

        return true;
    }
}
class WordDictionary {
private Node root;
    public WordDictionary() {
      root = new Node();
    }

    public void addWord(String word) {
     Node  node = root;

     for(int i = 0 ;i < word.length() ; i++){
         char ch = word.charAt(i);

         if(!node.containsKey(ch)){
            node.put(ch,new Node());
         }

         node = node.get(ch);
     }

     node.setEnd();
    }

    public boolean search(String word) {
        return helper(word,0,root);
    }
    public static boolean helper(String word,int idx,Node node){
        if(idx == word.length()){
            return node.isEnd();
        }


      
      if(word.charAt(idx) == '.'){
         for(int i=0;i<26;i++){
           if(node.containsKey((char)(i + 'a'))){
             if(helper(word,idx+1,node.get((char)(i + 'a')))){
                return true;
             }
          }
         }
         return false;
    }else{
         char ch = word.charAt(idx);

         if(!node.containsKey(ch)) return false;

        return helper(word,idx+1,node.get(ch));
    }
  

}
}
