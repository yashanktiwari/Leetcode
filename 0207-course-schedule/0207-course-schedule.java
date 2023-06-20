class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = calcIndegree(prerequisites, numCourses);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        makeGraph(prerequisites, map);
        return isPossible(prerequisites, numCourses, indegree, map);
    }

    public boolean isPossible(int[][] arr, int total, int[] indegree, Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int rv = queue.poll();

            count++;

            for(int n : map.get(rv)) {
                indegree[n]--;
                if(indegree[n] == 0) queue.add(n);
            }
        }

        return count == total;
    }

    public void makeGraph(int[][] arr, Map<Integer, List<Integer>> map) {
        for(int i=0; i<arr.length; i++) {
            map.get(arr[i][1]).add(arr[i][0]);
        }   
    }

    public int[] calcIndegree(int[][] arr, int total) {
        int[] indegree = new int[total];
        for(int i=0; i<arr.length; i++) {
            indegree[arr[i][0]]++;
        }
        return indegree;
    }
}