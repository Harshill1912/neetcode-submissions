class Solution {
    static int[][] dp;

    public static boolean isPalindrome(String s, int si, int ei) {
        while (si <= ei) {
            if (s.charAt(si) != s.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }

    public static int helper(String s, int si, int ei) {
        if (si > ei) return 0;
        if (si == ei) return 1;
        if (dp[si][ei] != -1) return dp[si][ei];

        if (isPalindrome(s, si, ei)) {
            return dp[si][ei] = ei - si + 1;
        }

        int take1 = helper(s, si, ei - 1);
        int take2 = helper(s, si + 1, ei);

        return dp[si][ei] = take1;
    }

    public String longestPalindrome(String s) {
    
        int n = s.length();
        if(n==1) return s;
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        helper(s, 0, n - 1);

       
        int maxLen = -1;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    startIdx = i;
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }
}
