class Solution {
    public static class Node
    {
        Node zero;
        Node one;

    }
    public int findMaximumXOR(int[] nums) 
    {
        Node root = new Node();
        for(int val : nums)
        {
            insert(root,val);
        }

        int xor = Integer.MIN_VALUE;
        for(int val : nums)
        {
            xor = Math.max(xor,getMaxXOR(root,val));
        }   
        return xor;
    }
    
    public static void insert(Node root,int val) {
        Node current = root;
        for (int i = 31; i >= 0; i--) {
            if ((val & (1 << i)) == 0) {
                if (current.zero != null) {
                    current = current.zero;
                } else {
                    Node newNode = new Node();
                    current.zero = newNode;
                    current = newNode;

                }
            } else {
                if (current.one != null) {
                    current = current.one;
                } else {
                    Node newNode = new Node();
                    current.one = newNode;
                    current = newNode;
                }

            }

        }
    }
        public static int getMaxXOR(Node root,int val)
        {
            int num = 0;
            Node current = root;
            for (int i = 31; i >= 0; i--)
            {
                int bit = (val & ( 1 << i));
                if(bit == 0)
                {
                    if(current.one != null)
                    {
                        num += (1 << i);
                        current = current.one;
                    }
                    else {
                        current = current.zero;
                    }

                }
                else {
                    if(current.zero != null)
                    {
                        num += (1 << i);
                        current = current.zero;
                    }
                    else {
                        current = current.one;
                    }
                }

            }
            return num;
        }
}