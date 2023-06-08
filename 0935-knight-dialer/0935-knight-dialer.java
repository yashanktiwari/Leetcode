class Solution {
    public int knightDialer(int n) {
        long ans = 0;
        int[][][] dp = new int[n][4][3];
        for(int[][] p : dp) {
            for(int[] a : p) {
                Arrays.fill(a, -1);
            }
        }
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                ans += count(n-1, i, j, dp);
            }
        }
        
        return (int)(ans % (1000000007));
    }
    
    int[] r = {-2, -2, 2, 2, 1, -1, -1, 1};
    int[] c = {-1, 1, -1, 1, -2, -2, 2, 2};

    public int count(int n, int i, int j, int[][][] dp) {
        if(i<0 || j<0 || i>= 4 || j>= 3 || (i==3 && j==0) || (i==3 && j == 2)) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        
        if(dp[n][i][j] != -1) return dp[n][i][j];
        long ans = 0;
        for(int t=0; t<c.length; t++) {
            ans += count(n-1, i+r[t], j+c[t], dp);
        }
        return dp[n][i][j] = (int) (ans%(1000000007));
    }
}