class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return calc_m(0, 1, fee, prices, dp);
    }

    // Recursive solution
    public int calc_r(int i, int shouldBuy, int fee, int[] arr) {
        if(i >= arr.length) return 0;

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_r(i+1, 0, fee, arr);
            int notBuy = 0 + calc_r(i+1, 1, fee, arr);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] - fee + calc_r(i+1, 1, fee, arr);
            int notSell = 0 + calc_r(i+1, 0, fee, arr);
            return Math.max(sell, notSell);
        }
    }

    // Memoization solution
    public int calc_m(int i, int shouldBuy, int fee, int[] arr, int[][] dp) {
        if(i >= arr.length) return 0;
        if(dp[i][shouldBuy] != -1) return dp[i][shouldBuy];

        if(shouldBuy == 1) {
            int buy = (-1 * arr[i]) + calc_m(i+1, 0, fee, arr, dp);
            int notBuy = 0 + calc_m(i+1, 1, fee, arr, dp);
            return dp[i][shouldBuy] = Math.max(buy, notBuy);
        } else {
            int sell = arr[i] - fee + calc_m(i+1, 1, fee, arr, dp);
            int notSell = 0 + calc_m(i+1, 0, fee, arr, dp);
            return dp[i][shouldBuy] = Math.max(sell, notSell);
        }
    }
}