class Solution {
    class Pair {
        int dst, cost;
        Pair(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], cost = flight[2];
            adj.get(u).add(new Pair(v, cost));
        }

      
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, k + 1}); 

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (node == dst) return cost;

            if (stops > 0) {
                for (Pair neighbor : adj.get(node)) {
                    pq.offer(new int[]{neighbor.dst, cost + neighbor.cost, stops - 1});
                }
            }
        }

        return -1;
    }
}
