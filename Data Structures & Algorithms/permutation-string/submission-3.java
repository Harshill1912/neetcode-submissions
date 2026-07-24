class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        HashSet<Character> set = new HashSet<>();
        int[] hash = new int[26];
        int[] hash2 = new int[26];

        int si = 0;

        for (int i = 0; i < n1; i++) {
            hash[s1.charAt(i) - 'a']++;
            hash2[s1.charAt(i) - 'a']++;
            set.add(s1.charAt(i));
        }

        for (int ei = 0; ei < n2; ei++) {
            char ch = s2.charAt(ei);

            if (set.contains(ch)) {
                while (hash[ch - 'a'] <= 0) {
                    hash[s2.charAt(si) - 'a']++;
                    si++;
                }
                hash[ch - 'a']--;
            } else {
                for (int i = 0; i < 26; i++) {
                    hash[i] = hash2[i];
                }
                si = ei + 1;
            }

            if (ei - si + 1 == n1) {
                boolean isExist = true;
                for (int k = 0; k < 26; k++) {
                    if (hash[k] != 0) {
                        isExist = false;
                        break;
                    }
                }
                if (isExist) return true;
            }
        }
        return false;
    }
}
