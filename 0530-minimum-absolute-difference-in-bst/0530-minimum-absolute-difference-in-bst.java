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
    public int getMinimumDifference(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        fill(root, pq);
        int ans = Integer.MAX_VALUE;
        while(pq.size() != 1) {
            int temp = pq.poll();
            ans = Math.min(pq.peek() - temp, ans);
        }
        return ans;
    }
    
    public void fill(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null) return;
        
        fill(root.left, pq);
        pq.add(root.val);
        fill(root.right, pq);
    }
}