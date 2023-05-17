class Solution {
        public int orangesRotting(int[][] grid) {
            return calc(grid);
        }

        public int calc(int[][] arr) {
            Queue<Pair> queue = new LinkedList<>();
            int[][] visited = new int[arr.length][arr[0].length];
            int maxTime = 0;

            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    if(arr[i][j] == 2) {
                        queue.add(new Pair(i, j, 0));
                    }
                }
            }

            while(!queue.isEmpty()) {
                Pair rp = queue.poll();
                
                int i = rp.i;
                int j = rp.j;
                int time = rp.time;
                maxTime = Math.max(maxTime, time);
                
                if(visited[i][j] == 2) {
                    continue;
                }
                
                visited[i][j] = 2;
                
                // top
                if(i-1 >=0 && arr[i-1][j] == 1 && visited[i-1][j] != 2) {
                    queue.add(new Pair(i-1, j, time+1));
                    arr[i-1][j] = 2;
                }
                
                // left
                if(j-1 >= 0 && arr[i][j-1] == 1 && visited[i][j-1] != 2) {
                    queue.add(new Pair(i, j-1, time+1));
                    arr[i][j-1] = 2;
                }
                
                // down
                if(i+1 < arr.length && arr[i+1][j] == 1 && visited[i+1][j] != 2) {
                    queue.add(new Pair(i+1, j, time+1));
                    arr[i+1][j] = 2;
                }
                
                // right
                if(j+1 < arr[0].length && arr[i][j+1] == 1 && visited[i][j+1] != 2) {
                    queue.add(new Pair(i, j+1, time+1));
                    arr[i][j+1] = 2;
                }
            }
            
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    if(arr[i][j] == 1 && visited[i][j] != 2) return -1;
                }
            }
            
            
            return maxTime;
        }
    }

class Pair {
    int i;
    int j;
    int time;
    Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
