class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i, new HashMap<>());
        }
        makeGraph(times, map);
        return findDelay(map, k, n);
    }

    public void makeGraph(int[][] arr, Map<Integer, Map<Integer, Integer>> map) {
        for(int i=0; i<arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int time = arr[i][2];
            map.get(u).put(v, time);
        }
    }

    public int findDelay(Map<Integer, Map<Integer, Integer>> map, int k, int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, 1000000000);
        distance[k] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(k, 0));
        while(!queue.isEmpty()) {
            Pair rp = queue.poll();
            int node = rp.node;
            int dist = rp.dist;
            for(int t : map.get(node).keySet()) {
                if(distance[t] > dist + map.get(node).get(t)) {
                    distance[t] = dist + map.get(node).get(t);
                    queue.add(new Pair(t, distance[t]));
                }
            }
        }
        int max = -1;
        for(int i=1; i<distance.length; i++) {
            max = Math.max(max, distance[i]);
        }
        return max >= 1000000000 ? -1 : max;
    }

    class Pair {
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}