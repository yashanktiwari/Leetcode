class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] arr = new int[n][n];
        makeGraph(edges, arr);
        calcDist(arr, n);

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(arr[i][j] <= distanceThreshold) count++;
            }
            if(count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }

    public void makeGraph(int[][] edges, int[][] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = (int) 1e9;
                if(i == j) arr[i][j] = 0;
            }
        }
        
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int distance = edges[i][2];

            arr[u][v] = distance;
            arr[v][u] = distance;
        }
    }

    public void calcDist(int[][] arr, int n) {
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
}