// Traverse from front and back
// Apply algorithm similar to kadanes
// Condn: if(pdt == 0) pdt = 1

class Solution {
    public int maxProduct(int[] nums) {
        int p = 1;
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            p *= x;
            max = Math.max(max, p);
            if(p == 0) p = 1;
        }

        p = 1;
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            p *= nums[i];
            max = Math.max(max, p);
            if(p == 0) p = 1;
        }

        return max;
    }
}