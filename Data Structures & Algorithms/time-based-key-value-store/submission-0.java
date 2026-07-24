class TimeMap {
  HashMap<String,HashMap<Integer,String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new HashMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

         Map<Integer, String> innerMap = map.get(key);
        int closestTime = -1;

        for (int time : innerMap.keySet()) {
            if (time <= timestamp && time > closestTime) {
                closestTime = time;
            }
        }

        return closestTime == -1 ? "" : innerMap.get(closestTime);

    }
}
