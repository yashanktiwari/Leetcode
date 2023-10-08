class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] rpdt = new int[n];
        int pdt = 1;
        for(int i=n-1; i>=0; i--) {
            rpdt[i] = pdt;
            pdt *= nums[i];
        }

        pdt = 1;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = pdt * rpdt[i];
            pdt *= nums[i];
        }
        return ans;
    }
}