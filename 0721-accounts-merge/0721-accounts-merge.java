class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint_Set set = new Disjoint_Set(n);
        Map<String, Integer> map = new HashMap<>();

        for(int j=0; j<accounts.size(); j++) {
            List<String> temp = accounts.get(j);
            for(int i=1; i<temp.size(); i++) {
                String s = temp.get(i);
                if(!map.containsKey(s)) {
                    map.put(s, j);
                } else {
                    set.unionByRank(j, map.get(s));
                }
            }
        }

        Map<Integer, List<String>> t = new HashMap<>();
        for(String s : map.keySet()) {
            int pos = map.get(s);
            int uParent = set.findParent(pos);

            if(t.containsKey(uParent)) {
                List<String> temp = t.get(uParent);
                temp.add(s);
                t.put(uParent, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                t.put(uParent, temp);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(int a : t.keySet()) {
            List<String> l = t.get(a);
            Collections.sort(l);
            int parent = set.findParent(a);
            l.add(0, accounts.get(parent).get(0));
            ans.add(l);
        } 
        return ans;
    }
}

public class Disjoint_Set {
    List<Integer> parent = new ArrayList<>();

    // For Union by rank
    List<Integer> rank = new ArrayList<>();


    public Disjoint_Set(int n) {
        for(int i=0; i<=n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if(node == parent.get(node)) return node;

        int ultimate_parent = findParent(parent.get(node));
        parent.set(node, ultimate_parent); // path compression
        return ultimate_parent;
    }

    public void unionByRank(int u, int v) {
        int pu = findParent(u); // ultimate parent of u
        int pv = findParent(v); // ultimate parent of v

        if(pu == pv) return;

        int rank_pu = rank.get(pu);
        int rank_pv = rank.get(pv);
        if(rank_pu > rank_pv) {
            parent.set(pv, pu);
        } else if(rank_pu < rank_pv) {
            parent.set(pu, pv);
        } else {
            parent.set(pu, pv);
            int rankV = rank.get(pv);
            rank.set(pv, rankV+1);
        }
    }
}