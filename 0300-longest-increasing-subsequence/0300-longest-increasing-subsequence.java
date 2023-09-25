class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return lis_t(nums);
    }

    // Recursive solution
    public int lis(int i, int last, int[] arr) {
        if(i == 0) {
            if(last == -1 || arr[0] < arr[last]) return 1;
            else return 0;
        }

        int pick = 0;
        if(last == -1 || arr[i] < arr[last]) {
            pick = 1 + lis(i-1, i, arr);
        }

        int notPick = 0 + lis(i-1, last, arr);

        return Math.max(pick, notPick);
    }

    // Memoization solution
    public int lis_m(int i, int last, int[] arr, int[][] dp) {
        if(i == 0) {
            if(last-1 == -1 || arr[0] < arr[last-1]) return 1;
            else return 0;
        }
        if(dp[i][last] != -1) return dp[i][last];

        int pick = 0;
        if(last-1 == -1 || arr[i] < arr[last-1]) {
            pick = 1 + lis_m(i-1, i+1, arr, dp);
        }

        int notPick = 0 + lis_m(i-1, last, arr, dp);

        return dp[i][last] = Math.max(pick, notPick);
    }

    // Tabulation solution
    public int lis_t(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for(int j=0; j<=n; j++) {
            if(j-1 == -1 || arr[0] < arr[j-1]) dp[0][j] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=n; j++) {
                int pick = 0;
                if(j-1 == -1 || arr[i] < arr[j-1]) {
                    pick = 1 + dp[i-1][i+1];
                }

                int notPick = 0 + dp[i-1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][0];
    }
}