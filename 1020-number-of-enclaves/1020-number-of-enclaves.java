class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
            for(int i=0; i<grid[0].length; i++) {
                if(grid[0][i] == 1) dfs(grid, 0, i, visited);
            }
            for(int i=0; i<grid.length; i++) {
                if(grid[i][0] == 1) dfs(grid, i, 0, visited);
            }
            for(int i=0; i<grid[0].length; i++) {
                if(grid[grid.length-1][i] == 1) dfs(grid, grid.length-1, i, visited);
            }
            for(int i=0; i<grid.length; i++) {
                if(grid[i][grid[0].length-1] == 1) dfs(grid, i, grid[0].length-1, visited);
            }

            for(int i=0; i<visited.length; i++) {
                for(int j=0; j<visited[0].length; j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) count++;
                }
            }
        return count;
    }
    
    public void dfs(int[][] arr, int sr, int sc, boolean[][] visited) {
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(sr, sc));
            while(!stack.isEmpty()) {
                Pair rp = stack.pop();

                int i = rp.i;
                int j = rp.j;

                if(visited[i][j]) continue;

                visited[i][j] = true;

                // Check for all the 4 adjacent neighbours
                // top
                if(i-1 >= 0 && !visited[i-1][j] && arr[i-1][j] == 1) {
                    stack.push(new Pair(i-1, j));
                }

                // left
                if(j-1 >= 0 && !visited[i][j-1] && arr[i][j-1] == 1) {
                    stack.push(new Pair(i, j-1));
                }

                // down
                if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] == 1) {
                    stack.push(new Pair(i+1, j));
                }

                // right
                if(j+1 < arr[0].length && !visited[i][j+1] && arr[i][j+1] == 1) {
                    stack.push(new Pair(i, j+1));
                }
            }
        }
    
    class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}