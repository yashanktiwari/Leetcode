class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        int i = 0;
        for(i=0; i<Math.min(strs[0].length(), strs[n-1].length()); i++) {
            if(strs[0].charAt(i) != strs[n-1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, i);
    }
}