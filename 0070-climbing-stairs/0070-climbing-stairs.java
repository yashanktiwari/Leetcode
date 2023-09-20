class Solution {
    public int climbStairs(int n) {
      int[] arr = new int[n+1];
      Arrays.fill(arr, -1);
      arr[0] = 0;
      return climb(n, arr);
    }

    // Memoization code
    public static int climb(int n, int[] arr) {
      if(n < 0) return 0;
      if(n == 0) return 1;
      if(arr[n] != -1) return arr[n];

      return arr[n] = climb(n-1, arr) + climb(n-2, arr);
    }
}