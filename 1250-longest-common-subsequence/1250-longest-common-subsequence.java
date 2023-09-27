class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        
        return lcs_t(text1, text2);
    }

    // Recursive solution
    public int lcs_r(int i, int j, String s1, String s2) {
        if(i == -1 || j == -1) return 0;

        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs_r(i-1, j-1, s1, s2);
        } else {
            return 0 + Math.max(lcs_r(i-1, j, s1, s2), lcs_r(i, j-1, s1, s2));
        }
    }

    // Memoization solution
    public int lcs_m(int i, int j, String s1, String s2, int[][] dp) {
        if(i == -1 || j == -1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs_m(i-1, j-1, s1, s2, dp);
        } else {
            return dp[i][j] = 0 + Math.max(lcs_m(i-1, j, s1, s2, dp), lcs_m(i, j-1, s1, s2, dp));
        }
    }

    // Shifting of index
    public int lcs_msoi(int i, int j, String s1, String s2, int[][] dp) {
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = 1 + lcs_msoi(i-1, j-1, s1, s2, dp);
        } else {
            return dp[i][j] = 0 + Math.max(lcs_msoi(i-1, j, s1, s2, dp), lcs_msoi(i, j-1, s1, s2, dp));
        }
    }

    // Tabulation solution
    public int lcs_t(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }       
            }
        }

        return dp[n][m];
    }
}