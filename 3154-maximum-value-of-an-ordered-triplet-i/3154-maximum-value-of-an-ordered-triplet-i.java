class Solution {
    public long maximumTripletValue(int[] nums) {
        return optimizedII(nums);
    }

    public long bruteForce(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    ans = Math.max(ans, (nums[i]-nums[j])*(long)nums[k]);
                }
            }
        }
        return ans;
    }

    // Two array approach
    public long optimized(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int max = 0;
        for(int i=0; i<n; i++) {
            leftMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        max = 0;
        for(int i=n-1; i>=0; i--) {
            rightMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        long ans = 0;
        for(int i=1; i<n-1; i++) {
            ans = Math.max(ans, (leftMax[i] - arr[i]) * (long) rightMax[i]);
        }
        return ans;
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