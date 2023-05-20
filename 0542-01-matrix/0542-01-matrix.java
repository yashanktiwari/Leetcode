class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        bfs(mat, ans);
        return ans;
    }
    
    public static void bfs(int[][] arr, int[][] ans) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            Pair rp = queue.poll();

            int i = rp.i;
            int j = rp.j;
            int time = rp.time;

            if(visited[i][j]) continue;

            ans[i][j] = time;

            visited[i][j] = true;

            // Check for all the 4 adjacent neighbours
            // top
            if(i-1 >= 0 && !visited[i-1][j] && arr[i-1][j] == 1) {
                queue.add(new Pair(i-1, j, time+1));
            }

            // left
            if(j-1 >= 0 && !visited[i][j-1] && arr[i][j-1] == 1) {
                queue.add(new Pair(i, j-1, time+1));
            }

            // down
            if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] == 1) {
                queue.add(new Pair(i+1, j, time+1));
            }

            // right
            if(j+1 < arr[0].length && !visited[i][j+1] && arr[i][j+1] == 1) {
                queue.add(new Pair(i, j + 1, time + 1));
            }
        }
    }

    static class Pair {
        int i;
        int j;
        int time;
        public Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
}