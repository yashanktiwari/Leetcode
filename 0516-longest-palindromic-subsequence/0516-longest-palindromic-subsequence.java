class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        // return lcs_m(0, 0, s, rev, dp);
        return lcs_t(s, rev);
    }

    // Recursive solution
    public int lcs_r(int i, int j, String s1, String s2) {
        if(i == s1.length() || j == s2.length()) return 0;

        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs_r(i+1, j+1, s1, s2);
        } else {
            return 0 + Math.max(lcs_r(i+1, j, s1, s2), lcs_r(i, j+1, s1, s2));
        }
    }

    // Memoization solution
    public int lcs_m(int i, int j, String s1, String s2, int[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs_r(i+1, j+1, s1, s2);
        } else {
            return dp[i][j] = 0 + Math.max(lcs_r(i+1, j, s1, s2), lcs_r(i, j+1, s1, s2));
        }
    }

    // Tabulation solution
    public int lcs_t(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}