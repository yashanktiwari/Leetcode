class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(dungeon, 0, 0, dp);
    }
    
    public static int solve(int[][] arr, int i, int j, int[][] dp) {
        if(i == arr.length || j == arr[0].length) return Integer.MAX_VALUE;

        if(i == arr.length-1 && j == arr[0].length-1) {
            return arr[i][j] <= 0 ? 1 - arr[i][j] : 1;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        // right
        int right = solve(arr, i, j+1, dp);

        // downwards
        int down = solve(arr, i+1, j, dp);

        int temp = Math.min(right, down) - arr[i][j];

        return dp[i][j] = temp <= 0 ? 1 : temp;
    }
}