class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if(map.containsKey(target - n)) {
                ans[1] = map.get(target-n);
                ans[0] = i;
                return ans;
            } else {
                map.put(n, i);
            }
        }
        return ans;
    }
}