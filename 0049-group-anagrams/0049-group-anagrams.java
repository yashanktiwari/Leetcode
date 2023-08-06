class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(map.containsKey(s)) {
                List<String> temp = map.get(s);
                temp.add(strs[i]);
                map.put(s, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s, temp);
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        for(String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }
}