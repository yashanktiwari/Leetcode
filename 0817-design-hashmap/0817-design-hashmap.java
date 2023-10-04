class MyHashMap {
    static class Node {
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;
    private int N;
    private LinkedList<Node> bucket[];

    public MyHashMap() {
        N = 4;
        bucket = new LinkedList[this.N];
        for(int i=0; i<this.N; i++) {
            bucket[i] = new LinkedList<>();
        }
    }
    
    private int hashFunction(Integer key) {
        int hash = key.hashCode();
        return Math.abs(hash) % N;
    }

    private void rehash() {
        LinkedList<Node> oldBucket[] = bucket;
        bucket = new LinkedList[N*2];
        this.N *= 2;

        for(int i=0; i<N; i++) {
            bucket[i] = new LinkedList<>();
        }

        for(int i=0; i<oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for(int j=0; j<ll.size(); j++) {
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }

    private int searchInLL(int key, int bi) {
        LinkedList<Node> ll = bucket[bi];
        for(int i=0; i<ll.size(); i++) {
            Node node = ll.get(i);
            if(node.key == key) return i;
        }
        return -1;
    }

    public void put(int key, int value) {
        int bi = hashFunction((Integer)key);
        int di = searchInLL(key, bi);

        if(di == -1) {
            bucket[bi].add(new Node(key, value));
            n++;
        } else {
            Node node = bucket[bi].get(di);
            node.value = value;
        }

        double lambda = (double) n/N;
        if(lambda > 2.0) {
            rehash();
        }
    }
    
    public int get(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di == -1) {
            return -1;
        } else {
            Node node = bucket[bi].get(di);
            return node.value;
        }
    }
    
    public void remove(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        
        if(di == -1) {
            return;
        } else {
            bucket[bi].remove(di);
            n--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */