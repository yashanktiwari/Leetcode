/*
Using DFT
Maintain a color array
For every node, compare its and its neighbours color. If they are same then return false.
After DFT, return true;
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        return solve(graph);
    }

    public boolean solve(int[][] arr) {
        int[] color = new int[arr.length];
        Arrays.fill(color, -1);
        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            if(color[i] == -1) {
                stack.push(new Pair(i, 0));
                while(!stack.isEmpty()) {
                    Pair rv = stack.pop();

                    if(color[rv.data] != -1) {
                        continue;
                    }

                    color[rv.data] = rv.color;

                    for(int t : arr[rv.data]) {
                        if(color[t] == -1) {
                            int currColor = rv.color;
                            int setColor = rv.color == 0 ? 1 : 0;
                            stack.push(new Pair(t, setColor));
                        } else {
                            if(color[t] == color[rv.data]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    class Pair {
        int data;
        int color;
        public Pair(int data, int color) {
            this.data = data;
            this.color = color;
        }
    }
}