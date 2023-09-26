class Solution {
    public int minDistance(String word1, String word2) {
        return (word1.length() + word2.length() - (2 * lcs_t(word1, word2)));
    }

    // Tabulation solution
    public int lcs_t(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
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

