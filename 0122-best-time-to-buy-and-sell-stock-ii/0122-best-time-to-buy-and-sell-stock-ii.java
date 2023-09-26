class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return calc_t(prices);
    }

    // Recursive solution
    public int calc_r(int i, int shouldBuy, int[] arr) {
        if(i == arr.length) {
            return 0;
        }

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_r(i+1, 0, arr);
            int notBuy = 0 + calc_r(i+1, 1, arr);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + calc_r(i+1, 1, arr);
            int notSell = 0 + calc_r(i+1, 0, arr);
            return Math.max(sell, notSell);
        }
    }

    // Memoization solution
    public int calc_m(int i, int shouldBuy, int[] arr, int[][] dp) {
        if(i == arr.length) {
            return 0;
        }
        if(dp[i][shouldBuy] != -1) return dp[i][shouldBuy];

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_m(i+1, 0, arr, dp);
            int notBuy = 0 + calc_m(i+1, 1, arr, dp);
            return dp[i][shouldBuy] = Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + calc_m(i+1, 1, arr, dp);
            int notSell = 0 + calc_m(i+1, 0, arr, dp);
            return dp[i][shouldBuy] = Math.max(sell, notSell);
        }
    }

    // Tabulation solution
    public int calc_t(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1; i>=0; i--) {
            for(int shouldBuy=0; shouldBuy<2; shouldBuy++) {
                if(shouldBuy == 1) {
                    int buy = (-1 * arr[i]) + dp[i+1][0];
                    int notBuy = 0 + dp[i+1][1];
                    dp[i][shouldBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = arr[i] + dp[i+1][1];
                    int notSell = 0 + dp[i+1][0];
                    dp[i][shouldBuy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }
}