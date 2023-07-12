/*
Find the nodes that are in a cycle or have incoming edges to a cycle.
These nodes will not be safe node, rest all will be.
If the node is visited and pathVisited, then it is present in a cycle so any node having incoming edge to that node will not be a safe node.
Use the same approach as to find the cycle in the directed graph.
*/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited, pathVisited, safeNodes);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    public boolean dfs(int[][] arr, int i, boolean[] visited, boolean[] pathVisited, List<Integer> safeNodes) {
        visited[i] = true;
        pathVisited[i] = true;
        for(int a : arr[i]) {
            if(!visited[a]) {
                boolean ans = dfs(arr, a, visited, pathVisited, safeNodes);
                if(ans) return ans;
            } else {
                if(pathVisited[a]) return true;
            }
        }

        pathVisited[i] = false;
        safeNodes.add(i);
        return false;
    }
}