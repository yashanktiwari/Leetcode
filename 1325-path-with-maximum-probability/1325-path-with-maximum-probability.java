class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(i, new HashMap<>());
        }
        makeGraph(edges, succProb, map);
        return findPath(map, start, end);
    }

    public void makeGraph(int[][] arr, double[] prob, Map<Integer, Map<Integer, Double>> map) {
        for(int i=0; i<arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            map.get(u).put(v, prob[i]);
            map.get(v).put(u, prob[i]);
        }
    }

    public double findPath(Map<Integer, Map<Integer, Double>> map, int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.prob > o2.prob) return -1;
            else return 1;
        });
        double[] arr = new double[map.size()];
        Arrays.fill(arr, -1000000000);
        pq.add(new Pair(start, 1.0));
        while(!pq.isEmpty()) {
            Pair rp = pq.poll();

            int node = rp.node;
            double prob = rp.prob;

            if(node == end) return prob;

            for(int n : map.get(node).keySet()) {
                System.out.println(prob * map.get(node).get(n));
                if(prob * map.get(node).get(n) > arr[n]) {
                    arr[n] = prob * map.get(node).get(n);
                    pq.add(new Pair(n, arr[n]));
                }
            }
        }

        return 0;
    }

    class Pair {
        int node;
        double prob;
        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}