class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] source = {0, 0};
        int[] destination = {grid.length-1, grid[0].length-1};
        // System.out.println((grid.length-1) + " " + (grid[0].length-1));
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
        
        while(!queue.isEmpty()) {
            Pair rp = queue.poll();
            int i = rp.i;
            int j = rp.j;
            int dist = rp.dist;

            if(i == destination[0] && j == destination[1]) {
                return dist;
            }

            // top
            if(i-1 >= 0 && grid[i-1][j] == 0) {
                if(dist + 1 < distance[i-1][j]) {
                    queue.add(new Pair(i-1, j, dist+1));
                    distance[i-1][j] = dist + 1;
                }
            }
            // left
            if(j-1 >= 0 && grid[i][j-1] == 0) {
                if(dist + 1 < distance[i][j-1]) {
                    queue.add(new Pair(i, j-1, dist+1));
                    distance[i][j-1] = dist + 1;
                }
            }
            // down
            if(i+1 < grid.length && grid[i+1][j] == 0) {
                if(dist + 1 < distance[i+1][j]) {
                    queue.add(new Pair(i+1, j, dist+1));
                    distance[i+1][j] = dist + 1;
                }
            }
            // right
            if(j+1 < grid[0].length && grid[i][j+1] == 0) {
                if(dist + 1 < distance[i][j+1]) {
                    queue.add(new Pair(i, j+1, dist+1));
                    distance[i][j+1] = dist + 1;
                }
            }

            //top right
            if(i-1 >= 0 && j+1 < grid[0].length && grid[i-1][j+1] == 0) {
                if(dist + 1 < distance[i-1][j+1]) {
                    queue.add(new Pair(i-1, j+1, dist+1));
                    distance[i-1][j+1] = dist + 1;
                }
            }

            //top left
            if(i-1 >= 0 && j-1 >= 0 && grid[i-1][j-1] == 0) {
                if(dist + 1 < distance[i-1][j-1]) {
                    queue.add(new Pair(i-1, j-1, dist+1));
                    distance[i-1][j-1] = dist + 1;
                }
            }

            //bottom right
            if(i+1 < grid.length && j+1 < grid[0].length && grid[i+1][j+1] == 0) {
                if(dist + 1 < distance[i+1][j+1]) {
                    queue.add(new Pair(i+1, j+1, dist+1));
                    distance[i+1][j+1] = dist + 1;
                }
            }

            //bottom left
            if(i+1 < grid.length && j-1 >= 0 && grid[i+1][j-1] == 0) {
                if(dist + 1 < distance[i+1][j-1]) {
                    queue.add(new Pair(i+1, j-1, dist+1));
                    distance[i+1][j-1] = dist + 1;
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