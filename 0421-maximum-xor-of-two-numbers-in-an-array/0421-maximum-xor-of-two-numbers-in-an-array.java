class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj = new Trie();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            obj.insert(nums[i]);
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, obj.getMax(nums[i]));
        }
        return ans;
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
            int currBit = (n >> i) & 1;

            if(!temp.containsKey(currBit)) {
                temp.put(currBit);
            }
            temp = temp.get(currBit);
        }
        temp.isEnd = true;
    }

    public int getMax(int n) {
        Node temp = root;
        int number = 0;
        for(int i=31; i>=0; i--) {
            int currBit = (n >> i) & 1;

            if(currBit == 0) {
                if(temp.containsKey(1)) {
                    temp = temp.get(1);
                    number += Math.pow(2, i);
                } else {
                    temp = temp.get(0);
                }
            } else {
                if(temp.containsKey(0)) {
                    temp = temp.get(0);
                    number += Math.pow(2, i);
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
    boolean isEnd;

    public Node() {
        arr = new Node[2];
        isEnd = false;
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