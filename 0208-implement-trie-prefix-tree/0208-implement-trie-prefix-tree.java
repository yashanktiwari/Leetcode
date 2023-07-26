class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        int n = word.length();
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)) {
                temp.put(ch);
            }
            temp = temp.get(ch);
        }
        temp.flag = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        int n = word.length();
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.flag == true;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        int n = prefix.length();
        for(int i=0; i<n; i++) {
            char ch = prefix.charAt(i);
            if(!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }
    
    class Node {
        Node[] arr;
        boolean flag;
        
        public Node() {
            arr = new Node[26];
            flag = false;
        }
        
        public void put(char ch) {
            arr[ch-'a'] = new Node();
        }
        
        public Node get(char ch) {
            return arr[ch-'a'];
        }
        
        public boolean containsKey(char ch) {
            return arr[ch-'a'] != null;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */