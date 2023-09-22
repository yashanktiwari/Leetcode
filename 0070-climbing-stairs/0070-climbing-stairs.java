class Solution {
    public int climbStairs(int n) {
      int[] dp = new int[n+1];
      Arrays.fill(dp, -1);
      dp[0] = 0;
      return climb_t(n);
    }

    // Memoization code
    public static int climb(int n, int[] dp) {
      if(n <= 1) return 1;
      if(dp[n] != -1) return dp[n];

      return dp[n] = climb(n-1, dp) + climb(n-2, dp);
    }

    // Tabulation code
    public static int climb_t(int n) {
      int[] dp = new int[n+1];
      dp[0] = 1;
      dp[1] = 1;
      for(int i=2; i<=n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
      }
      return dp[n];
    }

    // Minimizing the space complexity
    public static int climb_rsc(int n) {
      int prev = 1;
      int curr = 1;
      for(int i=2; i<=n; i++) {
        int sum = prev + curr;
        prev = curr;
        curr = sum;
      }
      return curr;
    }
}