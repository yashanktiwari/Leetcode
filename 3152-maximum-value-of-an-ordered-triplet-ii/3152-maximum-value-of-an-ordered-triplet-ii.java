class Solution {
    public long maximumTripletValue(int[] nums) {
        return optimizedII(nums);
    }

    // One array approach
    public long optimizedII(int[] arr) {
        int n = arr.length;
        int[] rightMax = new int[n];


        int max = 0;
        for(int i=n-1; i>=0; i--) {
            rightMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        max = arr[0];

        long ans = 0;
        for(int i=1; i<n-1; i++) {
            max = Math.max(max, arr[i]);
            ans = Math.max(ans, (max - arr[i]) * (long) rightMax[i]);
        }
        return ans;
    }
}