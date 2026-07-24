class Solution {
    class Pair {
        char ch;
        int val;

        Pair(char ch, int val) {
            this.ch = ch;
            this.val = val;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
            return y.val - x.val; // max-heap by val
        });

        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            // Check if last two chars in result are same as current
            int len = str.length();
            if (len >= 2 && str.charAt(len - 1) == curr.ch && str.charAt(len - 2) == curr.ch) {
                // We need to skip this char, try next one
                if (pq.isEmpty()) break; // no other choice

                Pair next = pq.poll();
                str.append(next.ch);
                next.val--;

                if (next.val > 0) pq.offer(next);
                pq.offer(curr); // put the skipped char back
            } else {
                // Safe to add this char
                str.append(curr.ch);
                curr.val--;

                if (curr.val > 0) pq.offer(curr);
            }
        }

        return str.toString();
    }
}
