class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        int ans = cc_m(n-1, amount, coins, dp);
        if(ans >= (int)1e9) return -1;
        else return ans;
    }

    // Recusive solution
    public int cc_r(int i, int amount, int[] arr) {
        if(i == 0) {
            if(amount % arr[0] == 0) return amount / arr[0];
            else return (int) 1e9;
        }

        int pick = (int) 1e9;
        if(arr[i] <= amount) pick = 1 + cc_r(i, amount - arr[i], arr);
        int notPick = cc_r(i-1, amount, arr);

        return Math.min(pick, notPick);
    }

    // Memoization solution
    public int cc_m(int i, int amount, int[] arr, int[][] dp) {
        if(i == 0) {
            if(amount % arr[0] == 0) return amount / arr[0];
            else return (int) 1e9;
        }
        if(dp[i][amount] != -1) return dp[i][amount];

        int pick = (int) 1e9;
        if(arr[i] <= amount) pick = 1 + cc_m(i, amount - arr[i], arr, dp);
        int notPick = cc_m(i-1, amount, arr, dp);

        return dp[i][amount] = Math.min(pick, notPick);
    }
}