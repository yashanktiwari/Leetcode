class Solution {
    public int findMin(int[] nums) {
        return find(nums);
    }

    // O(N) approach
    public int find(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }
}