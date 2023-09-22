class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rob_m(n-1, nums, dp);
    }

    // Recursion solution
    public int rob_r(int i, int[] arr) {
        if(i < 0) return 0;
        if(i == 0) return arr[i];

        int pick = arr[i] + rob_r(i-2, arr);

        int notPick = 0 + rob_r(i-1, arr);

        return Math.max(pick, notPick);
    }

    // Memoization solution
    public int rob_m(int i, int[] arr, int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return arr[i];
        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + rob_m(i-2, arr, dp);

        int notPick = 0 + rob_m(i-1, arr, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}