class Solution {
    public int numIdenticalPairs(int[] nums) {
        return calc(nums);
    }

    public int calc(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int ans = 0;
        for(int key : map.keySet()) {
            int val = map.get(key);
            ans += (val*(val-1))/2;
        }
    
        return ans;
    }
}