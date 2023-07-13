class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return calc(prices, 0, 1, dp);
    }

    /*
    if buy == 1, we can buy the stock
    */
    public int calc(int[] arr, int i, int buy, int[][] dp) {
        if(i == arr.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            int b = -1*arr[i] + calc(arr, i+1, 0, dp);
            int nb = 0 + calc(arr, i+1, 1, dp);
            return dp[i][buy] = Math.max(b, nb);
        } else {
            int s = arr[i] + calc(arr, i+1, 1, dp);
            int ns = 0 + calc(arr, i+1, 0, dp);
            return dp[i][buy] = Math.max(s, ns);
        }
    }
}