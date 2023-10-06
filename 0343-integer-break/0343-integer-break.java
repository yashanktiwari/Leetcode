class Solution {
    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        // return calc_m(n, 0, dp);
        return calc_t(n);
    }

    // Recursive Solution
    public int calc_r(int n, int step) {
        if(n == 0) {
            if(step < 2) return 0;
            else return 1;
        }

        int maxPdt = 1;
        for(int i=1; i<=n; i++) {
            int pdt = i * calc_r(n-i, step+1);
            maxPdt = Math.max(pdt, maxPdt);
        }
        return maxPdt;
    }

    // Memoization Solution
    public int calc_m(int n, int step, int[][] dp) {
        if(n == 0) {
            if(step < 2) return 0;
            else return 1;
        }

        if(dp[n][step] != -1) return dp[n][step];
        int maxPdt = 1;
        for(int i=1; i<=n; i++) {
            int pdt = i * calc_m(n-i, step+1, dp);
            maxPdt = Math.max(pdt, maxPdt);
        }
        return dp[n][step] = maxPdt;
    }

    // Tabulation Solution
    public int calc_t(int n) {
        int[][] dp = new int[n+1][n+1];

        for(int step=0; step<=n; step++) {
            if(step >= 2) dp[0][step] = 1;
        }

        for(int temp=1; temp<=n; temp++) {
            for(int step=n-1; step>=0; step--) {
                int maxPdt = 1;
                for(int i=1; i<=temp; i++) {
                    int pdt = i * dp[temp-i][step+1];
                    maxPdt = Math.max(pdt, maxPdt);
                }
                dp[temp][step] = maxPdt;
            }
        }
        return dp[n][0];
    }
}