class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int checkColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        colorFill(image, visited, sr, sc, color, checkColor);
        return image;
    }

    public void colorFill(int[][] image, boolean[][] visited, int sr, int sc, int color, int checkColor) {

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] == true || image[sr][sc] != checkColor) return;
        
        image[sr][sc] = color;
        visited[sr][sc] = true;

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        for(int x=0; x<4; x++) {
            colorFill(image, visited, sr+r[x], sc+c[x], color, checkColor);
        }
    }
}