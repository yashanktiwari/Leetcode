class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie obj = new Trie();

        Arrays.sort(nums);

        Pair[] pairs = new Pair[queries.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.max - b.max;
        });

        int x = 0;
        for(int[] temp : queries) {
            int a = temp[0];
            int b = temp[1];
            pq.add(new Pair(a, b, x));
            x++;
        }

        int[] ans = new int[queries.length];
        int i = 0;
        while(!pq.isEmpty()) {
            Pair rp = pq.poll();
            
            int n = rp.n;
            int max = rp.max;
            int idx = rp.idx;

            int temp = i;
            while(temp < nums.length && nums[temp] <= max) {
                obj.insert(nums[temp]);
                temp++;
            }
            i = temp;

            if(max < nums[0]) {
                ans[idx] = -1;
            } else {
                ans[idx] = obj.getMax(n);
            }

        }
        return ans;
    }
}

class Pair {
    int n;
    int max;
    int idx;

    public Pair(int n, int max, int idx) {
        this.n = n;
        this.max = max;
        this.idx = idx;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int n) {
        Node temp = root;
        for(int i=31; i>=0; i--) {
            int curBit = (n >> i) & 1;
            if(!temp.containsKey(curBit)) {
                temp.put(curBit);
            }
            temp = temp.get(curBit);
        }
    }

    public int getMax(int n) {
        Node temp = root;
        int number = 0;
        for(int i=31; i>=0; i--) {
            int curBit = (n >> i) & 1;
            if(curBit == 0) {
                if(temp.containsKey(1)) {
                    temp = temp.get(1);
                    number = number + (1 << i);
                } else {
                    temp = temp.get(0);
                }
            } else {
                if(temp.containsKey(0)) {
                    temp = temp.get(0);
                    number = number + (1 << i);
                } else {
                    temp = temp.get(1);
                }
            }
        }
        return number;
    }
}

class Node {
    Node[] arr;

    public Node() {
        arr = new Node[2];
    }

    public boolean containsKey(int bit) {
        return arr[bit] != null;
    }

    public Node get(int bit) {
        return arr[bit];
    }

    public void put(int bit) {
        arr[bit] = new Node();
    }
}