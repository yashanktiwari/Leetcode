class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] source = {0, 0};
        int[] destination = {grid.length-1, grid[0].length-1};
        return shortestPath(grid, source, destination);
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        Queue<Pair> queue = new LinkedList<>();
        if(grid[source[0]][source[1]] != 0) return -1;
        queue.add(new Pair(source[0], source[1], 1));
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            Arrays.fill(distance[i], 1000000000);
        }
        distance[source[0]][source[1]] = 0;
        
        int[] rows = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] cols = {0, -1, 0, 1, 1, -1, -1, 1};

        while(!queue.isEmpty()) {
            Pair rp = queue.poll();
            int i = rp.i;
            int j = rp.j;
            int dist = rp.dist;

            if(i == destination[0] && j == destination[1]) {
                return dist;
            }

            for(int t=0; t<rows.length; t++) {
                int newrow = i + rows[t];
                int newcol = j + cols[t];
                
                if(newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && grid[newrow][newcol] == 0) {
                    if(dist + 1 < distance[newrow][newcol]) {
                        queue.add(new Pair(newrow, newcol, dist+1));
                        distance[newrow][newcol] = dist + 1;
                    }
                }
            }

        }

        return -1;
    }

    class Pair {
        int i;
        int j;
        int dist;
        public Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}