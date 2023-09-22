class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] a1 = new int[n-1];
        int[] a2 = new int[n-1];

        System.arraycopy(nums, 0, a1, 0, n-1);
        System.arraycopy(nums, 1, a2, 0, n-1);
        return Math.max(rob_t(a1), rob_t(a2));
    }

    public int rob_t(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];

        for(int i=0; i<n; i++) {
            int pick = arr[i];
            if(i-2 >= 0) pick += dp[i-2];

            int notPick = 0;
            if(i-1 >= 0) notPick += dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}