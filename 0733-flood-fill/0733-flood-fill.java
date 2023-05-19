class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            solve(image, sr, sc, color, image[sr][sc]);
            return image;
        }

        public void solve(int[][] arr, int sr, int sc, int color, int initColor) {
            Queue<Pair> queue = new LinkedList<>();
            int[][] visited = new int[arr.length][arr[0].length];

            queue.add(new Pair(sr, sc));
            arr[sr][sc] = color;
            while(!queue.isEmpty()) {
                Pair rp = queue.poll();

                int i = rp.i;
                int j = rp.j;

                if(visited[i][j] == color) {
                    continue;
                }

                visited[i][j] = color;

                // Check for all the 4 adjacent neighbours
                // top
                if(i-1 >= 0 && arr[i-1][j] == initColor && visited[i-1][j] != color) {
                    queue.add(new Pair(i-1, j));
                    arr[i-1][j] = color;
                }

                // left
                if(j-1 >=0 && arr[i][j-1] == initColor && visited[i][j-1] != color) {
                    queue.add(new Pair(i, j-1));
                    arr[i][j-1] = color;
                }

                // down
                if(i+1 < arr.length && arr[i+1][j] == initColor && visited[i+1][j] != color) {
                    queue.add(new Pair(i+1, j));
                    arr[i+1][j] = color;
                }

                // right
                if(j+1 < arr[0].length && arr[i][j+1] == initColor && visited[i][j+1] != color) {
                    queue.add(new Pair(i, j+1));
                    arr[i][j+1] = color;
                }
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