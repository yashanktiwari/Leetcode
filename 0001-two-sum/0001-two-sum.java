class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int[] ans = new int[2];
        
        for(int i=0; i<n; i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}