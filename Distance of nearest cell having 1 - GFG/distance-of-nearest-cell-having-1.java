//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int[][] ans = new int[grid.length][grid[0].length];
        bfs(grid, ans);
        return ans;
    }

    public static void bfs(int[][] arr, int[][] ans) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 1) {
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
            if(i-1 >= 0 && !visited[i-1][j] && arr[i-1][j] == 0) {
                queue.add(new Pair(i-1, j, time+1));
            }
            
            // left
            if(j-1 >= 0 && !visited[i][j-1] && arr[i][j-1] == 0) {
                queue.add(new Pair(i, j-1, time+1));
            }
            
            // down
            if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] == 0) {
                queue.add(new Pair(i+1, j, time+1));
            }
            
            // right
            if(j+1 < arr[0].length && !visited[i][j+1] && arr[i][j+1] == 0) {
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