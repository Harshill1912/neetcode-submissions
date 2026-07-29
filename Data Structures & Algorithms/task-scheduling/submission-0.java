class Solution {
    class Pair{
        char ch;
        int freq;

        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Character,Integer> map=new HashMap<>();
        int[] time=new int[26];

        for(char ch : tasks) map.put(ch,map.getOrDefault(ch,0)+1);

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
           char ch=entry.getKey();
           int freq=entry.getValue();
           pq.offer(new Pair(ch,freq));
        }

        int count=0;
        int t=1;

        while(!pq.isEmpty()){
            ArrayList<Pair> list=new ArrayList<>();

            while(!pq.isEmpty() && 
            time[pq.peek().ch-'A'] !=0 && t - time[pq.peek().ch-'A']  <= n){
                list.add(pq.poll());
            }

            if(!pq.isEmpty()){
                Pair c=pq.poll();
                int nfreq=c.freq-1;
                time[c.ch-'A']=t;
                if(nfreq != 0) pq.offer(new Pair(c.ch,nfreq));
            }

            for(int i=0;i<list.size();i++){
                pq.offer(list.get(i));
            }

            count++;

            t++;
        }

        return count;
    }
}
