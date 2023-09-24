class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int p = 1;
        for(int x : nums) {
            p *= x;
            max = Math.max(p, max);
            if(p == 0) p = 1;
        }
        p = 1;
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            p *= nums[i];
            max = Math.max(p, max);
            if(p == 0) p = 1;
        }

        return max;
    }
}