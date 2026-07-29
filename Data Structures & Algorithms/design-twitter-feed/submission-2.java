class Twitter {
    class Pair {
        int tweetId;
        int time;
        Pair(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    int timer = 0;
    HashMap<Integer, ArrayList<Pair>> map;
    HashMap<Integer, ArrayList<Integer>> follow;
    public Twitter() {
        map = new HashMap<>();
        follow = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new ArrayList<>());
        follow.putIfAbsent(userId, new ArrayList<>());

        map.get(userId).add(new Pair(tweetId, timer++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        if (follow.containsKey(userId)) {
            for (int id : follow.get(userId)) {
                if (!map.containsKey(id))
                    continue;

                for (Pair p : map.get(id)) {
                    pq.offer(p);
                    if (pq.size() > 10)
                        pq.poll();
                }
            }
        }

        if (map.containsKey(userId)) {
            for (Pair p : map.get(userId)) {
                pq.offer(p);
                if (pq.size() > 10)
                    pq.poll();
            }
        }

        while (!pq.isEmpty())
            result.add(pq.poll().tweetId);

        Collections.reverse(result);

        return result;
    }

    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new ArrayList<>());

        if (followerId == followeeId)
            return;

        if (!follow.get(followerId).contains(followeeId))
            follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId))
            return;

        follow.get(followerId).remove(Integer.valueOf(followeeId));
    }
}