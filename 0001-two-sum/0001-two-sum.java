class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                array[0] = map.get(target-nums[i]);
                array[1] = i;
                return array;
            } else {
                map.put(nums[i], i);
            }
        }
        return array;
    }
}