class LFUCache {
 
HashMap<Integer,Integer> map;
HashMap<Integer,Integer> counts;
HashMap<Integer,LinkedHashSet<Integer>> list;
int size;
int min;
    public LFUCache(int capacity) {
        map=new HashMap<>();
        counts=new HashMap<>();
        list=new HashMap<>();
        list.put(1,new LinkedHashSet<>());
        size=capacity;
        min=-1;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        int val=map.get(key);
        
        int count=counts.get(key);

        counts.put(key,count+1);

        list.get(count).remove(key);

        if(count == min && list.get(count).size() == 0){
            min++;
        }

        list.computeIfAbsent(count+1,k->new LinkedHashSet<>()).add(key);

        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            get(key);
        }else{
            if(map.size() == size){
                int lfuKey=list.get(min).iterator().next();
                list.get(min).remove(lfuKey);
                map.remove(lfuKey);
                counts.remove(lfuKey);
            }
            map.put(key,value);
            counts.put(key,1);
            list.get(1).add(key);
            min=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */