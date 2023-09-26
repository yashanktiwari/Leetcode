class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return s.length() - lcs_t(s, rev);
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