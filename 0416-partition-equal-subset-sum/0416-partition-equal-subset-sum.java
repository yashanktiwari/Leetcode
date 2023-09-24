class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if((sum & 1) == 1) return false;
        else {
            int n = nums.length;
            int[][] dp = new int[n+1][(sum>>1)+1];
            for(int[] arr : dp) Arrays.fill(arr, -1);
            return (check_m(n-1, (sum>>1), nums, dp) == 1);
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
}