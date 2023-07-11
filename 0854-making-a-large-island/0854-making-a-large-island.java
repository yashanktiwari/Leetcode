class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Disjoint_Set set = new Disjoint_Set(n * m - 1);

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {

                    for(int x = 0; x < r.length; x++) {
                        int newr = i + r[x];
                        int newc = j + c[x];

                        if(newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] == 1) {
                            if(set.findParent(m*i + j) != set.findParent(m*newr + newc)) {
                                set.unionBySize(m*i + j, m*newr + newc);
                            }
                        }
                    }

                }
            }
        }

        boolean flag = false;
        
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int ans = 0;
                if(grid[i][j] == 0) {
                    flag = true;
                    Set<Integer> pset = new HashSet<>();
                    for(int x=0; x<r.length; x++) {
                        int newr = i + r[x];
                        int newc = j + c[x];

                        if(newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] == 1) {
                            pset.add(set.findParent(m*newr + newc));
                        }
                    }

                    for(int temp : pset) {
                        ans += set.sizes.get(temp);
                    }
                    ans += 1;
                    max = Math.max(max, ans);
                }
            }
        }
        if(!flag) return m*n;
        return max;
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