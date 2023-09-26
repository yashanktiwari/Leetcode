class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int[][] ar : dp) {
            for(int[] a : ar) Arrays.fill(a, -1);
        }

        return calc_m(0, 1, k, prices, dp);
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
}