class Solution {
    public int swimInWater(int[][] grid) {
        return solve(grid);
    }

    public int solve(int[][] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        pq.add(new Pair(0, 0, arr[0][0]));
        while(!pq.isEmpty()) {
            Pair rp = pq.poll();

            int i = rp.i;
            int j = rp.j;
            int cost = rp.cost;
            
            visited[i][j] = true;

            if(i == arr.length-1 && j == arr[0].length-1) return cost;

            for(int x=0; x<4; x++) {
                int newr = i + r[x];
                int newc = j + c[x];

                if(newr >= 0 && newc >= 0 && newr < arr.length && newc < arr[0].length && !visited[newr][newc]) {
                    pq.add(new Pair(newr, newc, Math.max(cost, arr[newr][newc])));
                }
            }
        }
        return 0;
    }

    class Pair {
        int i;
        int j;
        int cost;
        public Pair(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
}