

class LFUCache {
    private final Map<Integer, Integer> map;        // key -> value
    private final Map<Integer, Integer> counts;     // key -> frequency
    private final Map<Integer, LinkedHashSet<Integer>> list; // freq -> keys
    private final int capacity;
    private int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.counts = new HashMap<>();
        this.list = new HashMap<>();
        this.min = -1;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int val = map.get(key);
        int count = counts.get(key);
        counts.put(key, count + 1);

        list.get(count).remove(key);
        if (count == min && list.get(count).isEmpty()) {
            min++;
        }

        list.computeIfAbsent(count + 1, k -> new LinkedHashSet<>()).add(key);
        return val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);  // update frequency
            return;
        }

        if (map.size() >= capacity) {
            // Remove least frequently used key
            LinkedHashSet<Integer> minList = list.get(min);
            int lfuKey = minList.iterator().next();
            minList.remove(lfuKey);
            map.remove(lfuKey);
            counts.remove(lfuKey);
        }

        map.put(key, value);
        counts.put(key, 1);
        list.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        min = 1;  // Reset min to 1 for the new key
    }
}
