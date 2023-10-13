class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = (int) 1e9;
        int i=0, j=0;
        int sum = 0;
        int n = nums.length;
        while(j < n) {
            sum += nums[j];
                
            if(sum >= target) {
                while(sum >= target) {
                    sum -= nums[i];
                    i++;
                }
                ans = Math.min(ans, j-i+2);
            }
            j++;
        }
        if(ans >= (int) 1e9) return 0;
        return ans;
    }
}