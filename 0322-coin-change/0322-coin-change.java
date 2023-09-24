class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        int ans = cc_t(amount, coins);
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

    // Tabulation solution
    public int cc_t(int amount, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][amount+1];

        for(int[] ar : dp) Arrays.fill(ar, (int) 1e9);
        
        for(int j=0; j<=amount; j++) {
            if(j % arr[0] == 0) dp[0][j] = j / arr[0];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=amount; j++) {
                int pick = (int) 1e9;
                if(arr[i] <= j) pick = 1 + dp[i][j-arr[i]];
                int notPick = 0 + dp[i-1][j];

                dp[i][j] = Math.min(pick, notPick);
            }
        }

        return dp[n-1][amount];
    }
}