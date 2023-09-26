class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int[][] ar : dp) {
            for(int[] a : ar) Arrays.fill(a, -1);
        }
        return calc_t(prices);
    }

    // Recursive solution
    public int calc_r(int i, int shouldBuy, int k, int[] arr) {
        if(k == 0) return 0;
        if(i == arr.length) return 0;

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_r(i+1, 0, k, arr);
            int notBuy = calc_r(i+1, 1, k, arr);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + calc_r(i+1, 1, k-1, arr);
            int notSell = calc_r(i+1, 0, k, arr);
            return Math.max(sell, notSell);
        }
    }

    // Memoization solution
    public int calc_m(int i, int shouldBuy, int k, int[] arr, int[][][] dp) {
        if(k == 0) return 0;
        if(i == arr.length) return 0;
        if(dp[i][shouldBuy][k] != -1) return dp[i][shouldBuy][k];

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_m(i+1, 0, k, arr, dp);
            int notBuy = calc_m(i+1, 1, k, arr, dp);
            return dp[i][shouldBuy][k] = Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + calc_m(i+1, 1, k-1, arr, dp);
            int notSell = calc_m(i+1, 0, k, arr, dp);
            return dp[i][shouldBuy][k] = Math.max(sell, notSell);
        }
    }

    // Tabulation solution
    public int calc_t(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=n-1; i>=0; i--) {
            for(int shouldBuy=0; shouldBuy<2; shouldBuy++) {
                for(int k=1; k<3; k++) {
                    if(shouldBuy == 1) {
                        int buy = (-1 * arr[i]) + dp[i+1][0][k];
                        int notBuy = dp[i+1][1][k];
                        dp[i][shouldBuy][k] = Math.max(buy, notBuy);
                    } else {
                        int sell = arr[i] + dp[i+1][1][k-1];
                        int notSell = dp[i+1][0][k];
                        dp[i][shouldBuy][k] = Math.max(sell, notSell);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}