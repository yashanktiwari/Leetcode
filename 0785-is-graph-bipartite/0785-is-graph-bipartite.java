class Solution {
        public boolean isBipartite(int[][] graph) {
            return check(graph);
        }

        // Two colors are: 0 and 1
        public boolean check(int[][] arr) {
            int[] color = new int[arr.length];
            Arrays.fill(color, -1);
            Stack<Pair> stack = new Stack<Pair>();
            for(int i=0; i<arr.length; i++) {
                if(color[i] == -1) {
                    stack.push(new Pair(i, 0));
                    while(!stack.isEmpty()) {
                        Pair rp = stack.pop();

                        if(color[rp.data] != -1) {
                            continue;
                        }

                        color[rp.data] = rp.color;

                        for(int n : arr[rp.data]) {
                            if(color[n] != -1) {
                                if(color[n] == color[rp.data]) {
                                    return false;
                                }
                            } else {
                                int currcolor;
                                if(rp.color == 0) currcolor = 1;
                                else currcolor = 0;
                                stack.push(new Pair(n, currcolor));
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    class Pair {
        int data;
        int color;

        public Pair(int data, int color) {
            this.data = data;
            this.color = color;
        }
    }