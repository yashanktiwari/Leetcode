class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, Integer.MIN_VALUE);
        return calc_m(m-1, n-1, nums1, nums2, dp);
    }

    public int calc_r(int i, int j, int[] arr1, int[] arr2) {
        if(i < 0 || j < 0) return -(int)1e9;

        int pick = Math.max(arr1[i]*arr2[j], arr1[i]*arr2[j] + calc_r(i-1, j-1, arr1, arr2));
        int notPick = Math.max(calc_r(i-1, j, arr1, arr2), calc_r(i, j-1, arr1, arr2));

        return Math.max(pick, notPick);
    }

    public int calc_m(int i, int j, int[] arr1, int[] arr2, int[][] dp) {
        if(i < 0 || j < 0) return -(int)1e9;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int pick = Math.max(arr1[i]*arr2[j], arr1[i]*arr2[j] + calc_m(i-1, j-1, arr1, arr2, dp));
        int notPick = Math.max(calc_m(i-1, j, arr1, arr2, dp), calc_m(i, j-1, arr1, arr2, dp));

        return dp[i][j] = Math.max(pick, notPick);
    }
}