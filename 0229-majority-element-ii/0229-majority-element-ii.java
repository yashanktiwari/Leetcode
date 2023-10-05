class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int x : map.keySet()) {
            if(map.get(x) > n/3) list.add(x);
        }
        return list;
    }
}