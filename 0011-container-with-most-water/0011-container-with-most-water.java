class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int si = 0, ei = n-1;
        int ans = 0;
        while(si < ei) {
            int area = (ei-si) * Math.min(height[ei], height[si]);
            ans = Math.max(ans, area);
            if(height[ei] < height[si]) {
                ei--;
            } else if(height[ei] > height[si]) {
                si++;
            } else {
                si++;
            }
        }
        return ans;
    }
}