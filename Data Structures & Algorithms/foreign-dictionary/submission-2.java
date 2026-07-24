
class Solution {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, HashSet<Character> set) {
        int[] indegree = new int[26];

        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0 && set.contains((char)(i + 'a'))) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0 && set.contains((char)(neighbor + 'a'))) {
                    q.offer(neighbor);
                }
            }
        }

        return result;
    }

    public String foreignDictionary(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    adj.get(curr.charAt(j) - 'a').add(next.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            if (!found && curr.length() > next.length()) return "";
        }

        ArrayList<Integer> topo = topoSort(adj, set);
        if (topo.size() < set.size()) return "";


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < topo.size(); i++) {
            sb.append((char)(topo.get(i) + 'a'));
        }

        return sb.toString();
    }
}
