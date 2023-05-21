class Solution {
        public void solve(char[][] board) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int i=0; i<board[0].length; i++) {
                if(board[0][i] == 'O') dfs(board, 0, i, visited);
            }
            for(int i=0; i<board.length; i++) {
                if(board[i][0] == 'O') dfs(board, i, 0, visited);
            }
            for(int i=0; i<board[0].length; i++) {
                if(board[board.length-1][i] == 'O') dfs(board, board.length-1, i, visited);
            }
            for(int i=0; i<board.length; i++) {
                if(board[i][board[0].length-1] == 'O') dfs(board, i, board[0].length-1, visited);
            }
            
            for(int i=0; i<visited.length; i++) {
                for(int j=0; j<visited[0].length; j++) {
                    if(board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
                }
            }
        }

        public void dfs(char[][] arr, int sr, int sc, boolean[][] visited) {
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
                if(i-1 >= 0 && !visited[i-1][j] && arr[i-1][j] == 'O') {
                    stack.push(new Pair(i-1, j));
                }
                
                // left
                if(j-1 >= 0 && !visited[i][j-1] && arr[i][j-1] == 'O') {
                    stack.push(new Pair(i, j-1));
                }
                
                // down
                if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] == 'O') {
                    stack.push(new Pair(i+1, j));
                }
                
                // right
                if(j+1 < arr[0].length && !visited[i][j+1] && arr[i][j+1] == 'O') {
                    stack.push(new Pair(i, j+1));
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