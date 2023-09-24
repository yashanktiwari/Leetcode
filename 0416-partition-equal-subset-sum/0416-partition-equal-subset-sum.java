class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if((sum & 1) == 1) return false;
        else {
            int n = nums.length;
            int k = sum >> 1;
            int[][] dp = new int[n+1][k+1];
            for(int[] arr : dp) Arrays.fill(arr, -1);
            return (check_t(k, nums) == 1);
        }
    }

    // Recursive solution
    public int check_r(int i, int k, int[] arr) {
        if(k == 0) return 1;
        if(i == 0) {
            if(arr[0] == k) return 1;
            else return 0;
        }

        int pick = 0;
        if(k >= arr[i]) pick = check_r(i-1, k-arr[i], arr);
        int notPick = check_r(i-1, k, arr);

        if(pick == 1 || notPick == 1) return 1;
        else return 0;
    }

    // Memoization solution
    public int check_m(int i, int k, int[] arr, int[][] dp) {
        if(k == 0) return 1;
        if(i == 0) {
            if(arr[0] == k) return 1;
            else return 0;
        }

        if(dp[i][k] != -1) return dp[i][k];

        int pick = 0;
        if(k >= arr[i]) pick = check_m(i-1, k-arr[i], arr, dp);
        int notPick = check_m(i-1, k, arr, dp);

        if(pick == 1 || notPick == 1) return dp[i][k] = 1;
        else return dp[i][k] = 0;
    }

    // Tabulation solution
    public int check_t(int k, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][k+1];

        for(int i=0; i<=n; i++) dp[i][0] = 1;
        if(arr[0] <= k) dp[0][arr[0]] = 1;

        for(int i=1; i<n; i++) {
            for(int j=1; j<=k; j++) {
                int pick = 0;
                if(j >= arr[i]) pick = dp[i-1][j-arr[i]];
                int notPick = dp[i-1][j];

                if(pick == 1 || notPick == 1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        return dp[n-1][k];
    }
}