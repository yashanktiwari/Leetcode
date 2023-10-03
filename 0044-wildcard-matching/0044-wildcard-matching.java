class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        // return wildcardMatch_msoi(m, n, s, p, dp) == 1;
        return wildcardMatch_t(s, p) == 1;
    }

    // Recursive solution
    public boolean wildcardMatch_r(int i, int j, String s, String p) {
        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0) {
            for(int temp=j; temp>=0; temp--) {
                if(p.charAt(temp) != '*') return false;
            }
            return true;
        }

        if(s.charAt(i) == p.charAt(j)) {
            return wildcardMatch_r(i-1, j-1, s, p);
        } else {
            if(p.charAt(j) == '?') {
                return wildcardMatch_r(i-1, j-1, s, p);
            } else if(p.charAt(j) == '*') {
                return (wildcardMatch_r(i-1, j, s, p) || wildcardMatch_r(i, j-1, s, p));
            } else {
                return false;
            }
        }
    }

    // Memoization solution
    public int wildcardMatch_m(int i, int j, String s, String p, int[][] dp) {
        if(i < 0 && j < 0) return 1;
        if(j < 0 && i >= 0) return 0;
        if(i < 0 && j >= 0) {
            for(int temp=j; temp>=0; temp--) {
                if(p.charAt(temp) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = wildcardMatch_m(i-1, j-1, s, p, dp);
        } else {
            if(p.charAt(j) == '?') {
                return dp[i][j] = wildcardMatch_m(i-1, j-1, s, p, dp);
            } else if(p.charAt(j) == '*') {
                int multiple = wildcardMatch_m(i-1, j, s, p, dp);
                int single = wildcardMatch_m(i, j-1, s, p, dp);
                if(single == 1 || multiple == 1) return dp[i][j] = 1;
                else return dp[i][j] = 0;
            } else {
                return dp[i][j] = 0;
            }
        }
    }

    // Memoization shifting of index solution
    public int wildcardMatch_msoi(int i, int j, String s, String p, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(j == 0 && i > 0) return 0;
        if(i == 0 && j > 0) {
            for(int temp=j; temp>0; temp--) {
                if(p.charAt(temp-1) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == p.charAt(j-1)) {
            return dp[i][j] = wildcardMatch_msoi(i-1, j-1, s, p, dp);
        } else {
            if(p.charAt(j-1) == '?') {
                return dp[i][j] = wildcardMatch_msoi(i-1, j-1, s, p, dp);
            } else if(p.charAt(j-1) == '*') {
                int multiple = wildcardMatch_msoi(i-1, j, s, p, dp);
                int single = wildcardMatch_msoi(i, j-1, s, p, dp);
                if(single == 1 || multiple == 1) return dp[i][j] = 1;
                else return dp[i][j] = 0;
            } else {
                return dp[i][j] = 0;
            }
        }
    }

    // Tabulation solution
    public int wildcardMatch_t(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;
        for(int i=1; i<=m; i++) {
            dp[i][0] = 0;
        }

        for(int j=1; j<=n; j++) {
            boolean flag = true;
            for(int temp=j; temp>0; temp--) {
                if(p.charAt(temp-1) != '*') flag = false;;
            }
            if(flag) dp[0][j] = 1;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if(p.charAt(j-1) == '*') {
                        int multiple = dp[i-1][j];
                        int single = dp[i][j-1];
                        if(single == 1 || multiple == 1) dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[m][n];
    }
}