class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        return calc(nums);
    }

    // O(N) approach
    public int find(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    // O(log N) approach
    public int calc(int[] arr) {
        int n = arr.length;
        int si = 0, ei = n-1;
        int min = Integer.MAX_VALUE;
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(arr[si] <= arr[mid]) { // left is sorted
                min = Math.min(min, arr[si]);
                si = mid + 1;
            } else { // right is sorted
                if(arr[mid] <= arr[ei]) {
                    min = Math.min(min, arr[mid]);
                    ei = mid - 1;
                }
            }
        }
        return min;
    }
}