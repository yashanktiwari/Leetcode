class Solution {
    public int minimumEffortPath(int[][] heights) {
        return findPath(heights);   
    }

    public int findPath(int[][] arr) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0));
        int ans = Integer.MAX_VALUE;

        int distance[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) {
            Arrays.fill(distance[i], 1000000000);
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};
        while(!queue.isEmpty()) {
            Pair rp = queue.poll();
            int i = rp.i;
            int j = rp.j;
            int effort = rp.effort;

            if(i == arr.length-1 && j == arr[0].length-1) {
                ans = Math.min(ans, effort);
            }

            for(int t=0; t<row.length; t++) {
                int nrow = i + row[t];
                int ncol = j + col[t];

                if(nrow >= 0 && nrow < arr.length && ncol >= 0 && ncol < arr[0].length) {
                    if(Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j])) < distance[nrow][ncol]) {
                        distance[nrow][ncol] = Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j]));
                        queue.add(new Pair(nrow, ncol, Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j]))));
                    }
                }
            }
        }
        return ans;
    }

    class Pair {
        int i;
        int j;
        int effort;
        public Pair(int i, int j, int effort) {
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }
}