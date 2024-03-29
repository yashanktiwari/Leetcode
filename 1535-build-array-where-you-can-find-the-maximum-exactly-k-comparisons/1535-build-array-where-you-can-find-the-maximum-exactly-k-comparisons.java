/*
Since the elements of our array range from 1 to m, so we can try out every number at that position.
Whenever we place an element, the length increases and the largest value till now increases.
3 states ->
    n: to take care of the length of the LIS
    lar: to take care of the largest value till now
    len: to take care that the cost does not go beyond k
*/
class Solution {
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[m+1][n+1][n+1];
        for(int[][] ar : dp) {
            for(int[] a : ar) Arrays.fill(a, -1);
        }
        return (int)(solve(0, 0, n, m, k, dp) % ((int)1e9 + 7));
    }

    public long solve(int lar, int len, int n, int m, int k, int[][][] dp) {
        if(n == 0) {
            if(len == k) return 1;
            else return 0;
        }
        if(dp[lar][len][n] != -1) return dp[lar][len][n];

        int ans = 0;
        for(int i=1; i<=m; i++) {
            if(i > lar) {
                ans += solve(i, len+1, n-1, m, k, dp);
            } else {
                ans += solve(lar, len, n-1, m, k, dp);
            }
            ans = ans % 1000000007;
        }

        return dp[lar][len][n] = ans;
    }
}