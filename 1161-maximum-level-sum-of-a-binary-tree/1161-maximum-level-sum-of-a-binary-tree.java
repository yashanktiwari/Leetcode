/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }
    
    public int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> l = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                l.add(temp.val);
            }
            list.add(l);
        }
        
        int max = Integer.MIN_VALUE, ans = 0;
        for(int i=0; i<list.size(); i++) {
            ArrayList<Integer> t = list.get(i);
            int csum = 0;
            for(int j : t) {
                csum += j;
            }
            if(max < csum) {
                max = csum;
                ans = i+1;
            }
        }
        return ans;
    }
}