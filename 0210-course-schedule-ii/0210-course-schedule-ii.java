class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = calcIndegree(prerequisites, numCourses);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        makeGraph(map, prerequisites);
        return ordering(map, indegree, numCourses);
    }

    public int[] ordering(Map<Integer, List<Integer>> map, int[] indegree, int total) {
        int[] ans = new int[total];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int x = 0;
        while (!queue.isEmpty()) {
            int rv = queue.poll();

            ans[x++] = rv;

            for (int n : map.get(rv)) {
                indegree[n]--;
                if (indegree[n] == 0)
                    queue.add(n);
            }
        }

        if (x == total)
            return ans;

        return new int[0];
    }

    public void makeGraph(Map<Integer, List<Integer>> map, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.get(arr[i][1]).add(arr[i][0]);
        }
    }

    public int[] calcIndegree(int[][] arr, int total) {
        int[] indegree = new int[total];
        for (int i = 0; i < arr.length; i++) {
            indegree[arr[i][0]]++;
        }
        return indegree;
    }
}