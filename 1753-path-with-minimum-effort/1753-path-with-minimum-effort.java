class Solution {
    public int minimumEffortPath(int[][] heights) {
        return findPath(heights);   
    }

    public int findPath(int[][] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.effort > o2.effort) return 1;
            else if(o1.effort < o2.effort) return -1;
            else return 0;
        });
        pq.add(new Pair(0, 0, 0));
        int ans = -1;

        int distance[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) {
            Arrays.fill(distance[i], 1000000000);
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};
        while(!pq.isEmpty()) {
            Pair rp = pq.poll();
            int i = rp.i;
            int j = rp.j;
            int effort = rp.effort;

            if(i == arr.length-1 && j == arr[0].length-1) {
                return effort;
            }

            for(int t=0; t<row.length; t++) {
                int nrow = i + row[t];
                int ncol = j + col[t];

                if(nrow >= 0 && nrow < arr.length && ncol >= 0 && ncol < arr[0].length) {
                    if(Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j])) < distance[nrow][ncol]) {
                        distance[nrow][ncol] = Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j]));
                        pq.add(new Pair(nrow, ncol, Math.max(effort, Math.abs(arr[nrow][ncol] - arr[i][j]))));
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