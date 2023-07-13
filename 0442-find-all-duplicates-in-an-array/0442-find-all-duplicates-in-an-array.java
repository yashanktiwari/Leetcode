class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) list.add(n);
            else set.add(n);
        }
        return list;
    }
}