class Solution {
    public int equalPairs(int[][] grid) {
        return solve(grid);
    }
    
    public int solve(int[][] arr) {
        List<String> rows = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            String s = "";
            for(int j=0; j<arr.length; j++) {
                s += arr[i][j] + " ";
            }
            rows.add(s.trim());
        }
        
        List<String> cols = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            String s = "";
            for(int j=0; j<arr.length; j++) {
                s += arr[j][i] + " ";
            }
            cols.add(s.trim());
        }
        int count = 0;
        for(int i=0; i<rows.size(); i++) {
            for(int j=0; j<rows.size(); j++) {
                if(rows.get(i).equals(cols.get(j))) {
                    count++;
                }
            }
        }
        
        return count;
    }
}