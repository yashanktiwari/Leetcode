class Solution {
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return calc_m(0, 0, m, n, visited, dp);
    }

    public int calc_r(int i, int j, int m, int n, boolean[][] visited) {
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || i < 0 || j >= n || j < 0 || visited[i][j]) return 0;

        visited[i][j] = true;
        // right
        int right = calc_r(i, j+1, m, n, visited);
        // down
        int down = calc_r(i+1, j, m, n, visited);

        visited[i][j] = false;

        return right + down;
    }

    public int calc_m(int i, int j, int m, int n, boolean[][] visited, int[][] dp) {
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || i < 0 || j >= n || j < 0 || visited[i][j]) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        visited[i][j] = true;
        // right
        int right = calc_m(i, j+1, m, n, visited, dp);
        // down
        int down = calc_m(i+1, j, m, n, visited, dp);

        visited[i][j] = false;

        return dp[i][j] = right + down;
    }
}