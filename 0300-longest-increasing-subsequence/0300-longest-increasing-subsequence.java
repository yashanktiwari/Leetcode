class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return lis_m(n-1, 0, nums, dp);
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
}