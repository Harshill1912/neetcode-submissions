class Solution {
    class Pair{
        String st;
        int stps;
        Pair(String st,int stps){
            this.st=st;
            this.stps=stps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> seen=new HashSet<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> b.stps-a.stps);
        pq.offer(new Pair(beginWord,1));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            String st=curr.st;
            int stps=curr.stps;

            if(st.equals(endWord)) return stps;

            for(int i=0;i<st.length();i++){
                for(char ch='a';ch<='z';ch++){
                    StringBuilder str=new StringBuilder(st);
                    str.setCharAt(i,ch);
                    if(wordList.contains(str.toString()) && !seen.contains(str.toString())){
                          pq.offer(new Pair(str.toString(),stps+1));
                          seen.add(str.toString());
                    }
                }
            }
        }
        return 0;
    }
}
