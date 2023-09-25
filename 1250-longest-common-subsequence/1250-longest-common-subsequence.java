class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return lcs_t(text1, text2);
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
            return dp[i][j] = 1 + lcs_m(i+1, j+1, s1, s2, dp);
        } else {
            return dp[i][j] = 0 + Math.max(lcs_m(i+1, j, s1, s2, dp), lcs_m(i, j+1, s1, s2, dp));
        }
    }

    // Tabulation solution
    public int lcs_t(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=m-1; i>=0; i--) {
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