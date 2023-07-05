public class Trie {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
    }
    

    private Node root;

    public Trie() {
        Node nn = new Node();
        nn.ch = '*';
        this.root = nn;
    }

    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.child.containsKey(ch)) {
                curr = curr.child.get(ch);
            } else {
                Node nn = new Node();
                nn.ch = ch;
                curr.child.put(ch, nn);
                curr = nn;
            }
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.child.containsKey(ch)) {
                return false;
            }
            curr = curr.child.get(ch);
        }
        return curr.isTerminal;
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.child.containsKey(ch)) {
                return false;
            }
            curr = curr.child.get(ch);
        }
        return true;
    }
}