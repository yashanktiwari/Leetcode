class Solution {
    public int removeStones(int[][] stones) {
        int n = 0;
        int m = 0;

        for(int i=0; i<stones.length; i++) {
            n = Math.max(n, stones[i][0]);
            m = Math.max(m, stones[i][1]);
        }
        
        Disjoint_Set set = new Disjoint_Set(n+m+1);

        /*
         * Disjoint set:
         * rows -> 0, 1, 2, 3, 4...
         * cols -> number of rows + 1, 2, 3, 4....
         */

        for(int i=0; i<stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            if(set.findParent(row) != set.findParent(n+1+col)) {
                set.unionBySize(row, n+1+col);
            }
        }

        int count = 0;
        for(int x=0; x<set.parent.size(); x++) {
            if(x == set.parent.get(x)) {
                if(set.sizes.get(x) != 1) {
                    count++;
                }
            }
        }
        return stones.length - count;
    }
}

public class Disjoint_Set {
    List<Integer> parent = new ArrayList<>();

    // For Union by size
    List<Integer> sizes = new ArrayList<>();

    public Disjoint_Set(int n) {
        for(int i=0; i<=n; i++) {
            parent.add(i);

            sizes.add(1);
        }
    }

    public int findParent(int node) {
        if(node == parent.get(node)) return node;

        int ultimate_parent = findParent(parent.get(node));
        parent.set(node, ultimate_parent); // path compression
        return ultimate_parent;
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u); // ultimate parent of u
        int pv = findParent(v); // ultimate parent of v

        if(pu == pv) return;
        if(sizes.get(pu) > sizes.get(pv)) {
            parent.set(pv, pu);
            sizes.set(pu, sizes.get(pu)+sizes.get(pv));
        } else {
            parent.set(pu, pv);
            sizes.set(pv, sizes.get(pu)+sizes.get(pv));
        }
    }
}
